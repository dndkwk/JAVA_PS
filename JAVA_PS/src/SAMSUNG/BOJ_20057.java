package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_20057 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[][] board;
	static int[][] snail;
	static int[] dy = { 0, 1, 0, -1 }; // RDLU
	static int[] dx = { 1, 0, -1, 0 };
	static int sy, sx;
	static int ans;

	static boolean OOB(int ny,int nx) {
		if(ny < 0 || ny>=N || nx<0 || nx>=N) {
			return true;
		}
		return false;
	}
	
	static void up(int y,int x,int a,int b,int c,int d) {
		int t1=(int)(board[y][x]*0.01);
		int t2=(int)(board[y][x]*0.02);
		int t5=(int)(board[y][x]*0.05);
		int t7=(int)(board[y][x]*0.07);
		int t10=(int)(board[y][x]*0.1);
		int alpha=board[y][x]-2*(t1+t2+t7+t10)-t5;
		
		int ny=0;
		int nx=0;
		ny=y+dy[a]*2;
		nx=x+dx[a]*2;
		if(OOB(ny,nx)) {
			ans+=t5;
		}else {
			board[ny][nx]+=t5;
		}
		
		ny=y+dy[b]*2;
		nx=x+dx[b]*2;
		if(OOB(ny,nx)) {
			ans+=t2;
		}else {
			board[ny][nx]+=t2;
		}
		
		ny=y+dy[c]*2;
		nx=x+dx[c]*2;
		if(OOB(ny,nx)) {
			ans+=t2;
		}else {
			board[ny][nx]+=t2;
		}
		
		//
		ny=y+dy[a]+dy[b];
		nx=x+dx[a]+dx[b];
		if(OOB(ny,nx)) {
			ans+=t10;
		}else {
			board[ny][nx]+=t10;
		}
		
		ny=y+dy[a]+dy[c];
		nx=x+dx[a]+dx[c];
		if(OOB(ny,nx)) {
			ans+=t10;
		}else {
			board[ny][nx]+=t10;
		}
		//
		ny=y+dy[b];
		nx=x+dx[b];
		if(OOB(ny,nx)) {
			ans+=t7;
		}else {
			board[ny][nx]+=t7;
		}
		
		ny=y+dy[c];
		nx=x+dx[c];
		if(OOB(ny,nx)) {
			ans+=t7;
		}else {
			board[ny][nx]+=t7;
		}
		//
		ny=y+dy[d]+dy[b];
		nx=x+dx[d]+dx[b];
		if(OOB(ny,nx)) {
			ans+=t1;
		}else {
			board[ny][nx]+=t1;
		}
		
		ny=y+dy[d]+dy[c];
		nx=x+dx[d]+dx[c];
		if(OOB(ny,nx)) {
			ans+=t1;
		}else {
			board[ny][nx]+=t1;
		}
		//
		ny=y+dy[a];
		nx=x+dx[a];
		if(OOB(ny,nx)) {
			ans+=alpha;
		}else {
			board[ny][nx]+=alpha;
		}
	}
	
	static void show() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j]+" ");;
			}
			System.out.println("");
		}
		System.out.println("");
	}


	public static void main(String[] args) throws Exception {
		
		N = stoi(br.readLine());
		board = new int[N][N];
		snail = new int[N][N];
		int y = 0, x = 0, v = N * N - 1, dir = 0;
		while (v > 0) {
			snail[y][x] = v--;
			while (true) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if ((ny < 0 || ny >= N || nx < 0 || nx >= N) || snail[ny][nx] != 0) {
					dir = (dir + 1) % 4;
					continue;
				}
				y = ny;
				x = nx;
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = stoi(st.nextToken());
			}
		}
		sy = N / 2;
		sx = N / 2;
		ans = 0;
		int d = 0;
		for (int t = 0; t < N * N; t++) {
			for (int i = 0; i < 4; i++) {
				int ny = sy + dy[i];
				int nx = sx + dx[i];
				if(OOB(ny,nx)) {
					continue;
				}
				if (snail[sy][sx] + 1 == snail[ny][nx]) {
					d = i;
					break;
				}
			}
			if(sy==0 && sx==0) {
				break;
			}
			sy += dy[d];
			sx += dx[d];
//			show();
			if (board[sy][sx] == 0) {
				continue;
			}
			if (d == 0) {
				up(sy,sx,0,1,3,2);
			} else if (d == 1) {
				up(sy,sx,1,0,2,3);
			} else if (d == 2) {
				up(sy,sx,2,1,3,0);
			} else if (d == 3) {
				up(sy,sx,3,2,0,1);
			}
			board[sy][sx]=0;
		}
		
		System.out.println(ans);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
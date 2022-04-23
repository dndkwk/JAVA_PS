package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_14503 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M;
	static int r, c, d;
	static int[][] board;
	static boolean[][] vis;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int ans=0,cnt=0;
	
	static int behind(int idx) {
		switch(idx) {
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 0;
		case 3:
			return 1;
		}
		return -1;
	}

	static int left(int idx) {
		switch(idx) {
		case 0:
			return 3;
		case 1:
			return 0;
		case 2:
			return 1;
		case 3:
			return 2;
		}
		return -1;
	}
	
	static void sol() {
		vis[r][c]=true;
		ans++;
		while(true) {
			d=left(d);
			int nr=r+dy[d];
			int nc=c+dx[d];
			if(nr < 0 || nr >= N || nc <0 || nc>=M) {
				break;
			}
			if(board[nr][nc]==0 && vis[nr][nc]==false) {
				r=nr;
				c=nc;
				vis[nr][nc]=true;
				ans++;
				cnt=0;
			}else {
				cnt++;
			}
			if(cnt==4) {
				cnt=0;
				int idx=behind(d);
				if(board[r+dy[idx]][c+dx[idx]]==1) {
					break;
				}else {
					r=r+dy[idx];
					c=c+dx[idx];
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = stoi(st.nextToken());
		c = stoi(st.nextToken());
		d = stoi(st.nextToken());
		
		board=new int[N][M];
		vis=new boolean[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j]=stoi(st.nextToken());
			}
		}
		
		sol();
		
		System.out.println(ans);
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_19237 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M, k;
	static int[][] board;
	static int[][] dump_board;
	static sm[][] smells;
	static int[][][] dirs;
	static boolean[] vis;
	static node[] sharks;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static class node {
		int y;
		int x;
		int dir;

		public node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		public node(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}
	static class sm{
		int idx;
		int cnt;
		public sm(int idx, int cnt) {
			super();
			this.idx = idx;
			this.cnt = cnt;
		}
	}

	static boolean check() {
		if (!vis[1]) {
			for (int i = 2; i <= M; i++) {
				if (!vis[i]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	static void smell() {
		for (int i = 1; i <= M; i++) {
			if (vis[i]) {//격자점 나간 상어 스킵
				continue;
			}
			smells[sharks[i].y][sharks[i].x] = new sm(i,k);
		}
	}

	static void cnt_smell() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (smells[i][j] !=null) {
					smells[i][j].cnt--;
					if(smells[i][j].cnt==0) {
						smells[i][j]=null;
					}
				}
			}
		}
	}

	static void move() {
		for(int i=1;i<=M;i++) {
			if(vis[i]) {
				continue;
			}
			node cur=sharks[i];
			boolean check=false;
			//냄새 없는 칸
			for(int j=0;j<4;j++) {
				int ny=cur.y+dy[dirs[i][cur.dir][j]];
				int nx=cur.x+dx[dirs[i][cur.dir][j]];
				
				if(nx < 0|| nx>=N || ny<0||ny>=N) {
					continue;
				}
				
				//냄새없는 칸
				if(smells[ny][nx]==null) {
					if(dump_board[ny][nx]==0) {
						//아무도 없음
						dump_board[ny][nx]=i;
						
						sharks[i].y=ny;
						sharks[i].x=nx;
						sharks[i].dir=dirs[i][cur.dir][j];
						check=true;
					}else if(dump_board[ny][nx] > i){
						//누군가 있음 하지만 내가 번호 더 작음
						vis[dump_board[ny][nx]]=true;
						dump_board[ny][nx]=i;
						
						sharks[i].y=ny;
						sharks[i].x=nx;
						sharks[i].dir=dirs[i][cur.dir][j];
						check=true;
					}else if(dump_board[ny][nx] < i) {
						//내 번호 더 큼
						//탈락
						vis[i]=true;
					}
					break;
				}
			}
			
			if(check) {
				continue;
			}
			
			//자기 냄새 있나?
			for(int j=0;j<4;j++) {
				int ny=cur.y+dy[dirs[i][cur.dir][j]];
				int nx=cur.x+dx[dirs[i][cur.dir][j]];
				
				if(nx < 0|| nx>=N || ny<0||ny>=N) {
					continue;
				}
				
				//자기 냄새 있는 칸 발견
				if(smells[ny][nx]!=null && smells[ny][nx].idx==i) {
					dump_board[ny][nx]=i;
					
					sharks[i].y=ny;
					sharks[i].x=nx;
					sharks[i].dir=dirs[i][cur.dir][j];
					break;
				}
			}
		}
		
		
		for(int i=0;i<N;i++) {//업데이트
			for(int j=0;j<N;j++) {
				board[i][j]=dump_board[i][j];
				dump_board[i][j]=0;
			}			
		}
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		k = stoi(st.nextToken());

		board = new int[N][N];
		dump_board = new int[N][N];
		smells = new sm[N][N];
		dirs = new int[M + 1][4][4];
		sharks = new node[M + 1];
		vis = new boolean[M + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = stoi(st.nextToken());
				if (board[i][j] != 0) {
					// 상어
					sharks[board[i][j]] = new node(i, j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			// 상어 방향
			sharks[i].dir = stoi(st.nextToken()) - 1;
		}

		for (int i = 1; i <= M; i++) {
			for (int r = 0; r < 4; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 4; c++) {
					dirs[i][r][c] = stoi(st.nextToken()) - 1;
				}
			}
		}
		int ans = -1;
		int t = 0;
		while (t <= 1000) {
			if (check()) {
				ans = t;
				break;
			}
			smell();
			move();
			cnt_smell();
			t++;
		}

		System.out.println(ans);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
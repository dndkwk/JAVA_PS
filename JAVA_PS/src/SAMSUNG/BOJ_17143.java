package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_17143 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int R, C, M;
	static node[] sharks;
	static node[][] board;
	static boolean[] vis;
	static int sum = 0;
	static int[] dx = { 0, 0, 0, 1, -1 };
	static int[] dy = { 0, -1, 1, 0, 0 };

	static class node {
		int r, c, s, d, z, i;

		public node(int r, int c, int s, int d, int z, int i) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.i = i;
		}
	}

	static void fishing(int idx) {
		for (int i = 0; i < R; i++) {
			if (board[i][idx] != null) {
//				System.out.println(i+" "+idx);
				sum += board[i][idx].z;
				vis[board[i][idx].i] = true;
				board[i][idx] = null;
				break;
			}
		}
	}

	static void move() {
		for (int t = 0; t < M; t++) {
			board[sharks[t].r][sharks[t].c] = null;
		}
		for (int t = 0; t < M; t++) {
			if (vis[t]) {
				continue;
			}
			int r, c, s, d;
			r = sharks[t].r;
			c = sharks[t].c;
			s = sharks[t].s;
			d = sharks[t].d;
			if(d==1 || d==2) {
				s%=2*(R-1);
			}else {
				s%=2*(C-1);
			}
			for(int i=0;i<s;i++) {
				r=r+dy[d];
				c=c+dx[d];
				if(r<0 || r>=R || c<0||c>=C) {
					if(d==1) {
						d=2;
					}else if(d==2) {
						d=1;
					}else if(d==3) {
						d=4;
					}else if(d==4) {
						d=3;
					}
					r=r+dy[d]*2;
					c=c+dx[d]*2;
				}
			}
			sharks[t].r=r;
			sharks[t].c=c;
			sharks[t].d=d;
			if(board[r][c]!=null) {
				if(board[r][c].z<sharks[t].z) {
					vis[board[r][c].i]=true;
					board[r][c]=sharks[t];
				}else {
					vis[sharks[t].i]=true;
				}
			}else {
				board[r][c]=sharks[t];
			}
		}
		for (int t = 0; t < M; t++) {
			if (vis[t]) {
				continue;
			}
			board[sharks[t].r][sharks[t].c] = sharks[t];
		}
		
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		M = stoi(st.nextToken());
		sharks = new node[M];
		vis = new boolean[M];
		board = new node[R][C];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r, c, s, d, z;
			r = stoi(st.nextToken())-1;
			c = stoi(st.nextToken())-1;
			s = stoi(st.nextToken());
			d = stoi(st.nextToken());
			z = stoi(st.nextToken());
			sharks[i] = new node(r, c, s, d, z, i);
			board[r][c] = sharks[i];
		}

		for (int t = 0; t < C; t++) {
//			System.out.println(t);
			fishing(t);
			move();
		}

		System.out.println(sum);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

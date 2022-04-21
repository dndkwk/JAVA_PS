package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_3190 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, K, L;
	static int[][] board;
	static ArrayList<pair> dirs;
	static int cnt = 0;
	static int[] ddy = { -1, 0, 1, 0 };// URDL
	static int[] ddx = { 0, 1, 0, -1 };

	static class pair {
		int t;
		String dir;

		public pair(int t, String dir) {
			super();
			this.t = t;
			this.dir = dir;
		}
	}

	static class node {
		int y;
		int x;

		public node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static void sol() {
		int idx=1;
		int dy = ddy[idx];
		int dx = ddx[idx];
		int y = 0, x = 0;
		Queue<node> q = new LinkedList<node>();
		q.add(new node(0, 0));
		for (int i = 0; i < dirs.size(); i++) {
			while (cnt != dirs.get(i).t) {
				cnt++;
				y += ddy[idx];
				x += ddx[idx];
				if (y < 0 || y >= N || x < 0 || x >= N) {
					return;
				}
				if (board[y][x] == 2) {// 자기 몸통
					return;
				}
				q.add(new node(y, x));
				if (board[y][x] == 0) {// 사과가 아님
					board[y][x] = 2;
					node tail = q.poll();
					board[tail.y][tail.x] = 0;
				} else if (board[y][x] == 1) {
					board[y][x] = 2;
				}
//				for(int ii=0;ii<N;ii++) {
//					for(int jj=0;jj<N;jj++) {
//						System.out.print(board[ii][jj]+"");
//					}			
//					System.out.println("");
//				}
//				System.out.println("");
			}
			if (dirs.get(i).dir.equals("L")) {// 왼쪽
				idx--;
				if(idx<0) {
					idx=3;
				}
			} else {
				idx++;
				idx%=4;
			}
		}
		
		while(true) {
			cnt++;
			y += ddy[idx];
			x += ddx[idx];
			if (y < 0 || y >= N || x < 0 || x >= N) {
				return;
			}
			if (board[y][x] == 2) {// 자기 몸통
				return;
			}
			q.add(new node(y, x));
			if (board[y][x] == 0) {// 사과가 아님
				board[y][x] = 2;
				node tail = q.poll();
				board[tail.y][tail.x] = 0;
			} else if (board[y][x] == 1) {
				board[y][x] = 2;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		N = stoi(br.readLine());
		K = stoi(br.readLine());
		board=new int[N][N];
		dirs=new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = stoi(st.nextToken()) - 1;
			int x = stoi(st.nextToken()) - 1;
			board[y][x] = 1;
		}
		L = stoi(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int t = stoi(st.nextToken());
			String dir = st.nextToken();
			dirs.add(new pair(t, dir));
		}
//		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(board[i][j]+"");
//			}			
//			System.out.println("");
//		}
//		System.out.println("");
		sol();
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(board[i][j]+"");
//			}			
//			System.out.println("");
//		}
		System.out.println(cnt);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

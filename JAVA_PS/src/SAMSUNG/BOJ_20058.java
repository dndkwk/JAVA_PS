package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_20058 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, Q;
	static int[][] board;
	static int[][] dump_board;
	static boolean[][] vis;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static void calc(int y, int x, int num) {
		for(int i=0;i<num;i++) {
			for(int j=0;j<num;j++) {
				dump_board[y+j][x+num-i-1]=board[y+i][x+j];
			}			
		}

	}

	static void storm(int stage) {
		int m = (int) Math.pow(2, stage);
		
		for (int i = 0; i < N; i = i + m) {
			for (int j = 0; j < N; j = j + m) {
				calc(i, j, m);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = dump_board[i][j];
				dump_board[i][j] = 0;
			}
		}
	}

	static void minus() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] != 0) {
					int ice = 0;
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
							continue;
						}

						if (board[ny][nx] != 0) {
							ice++;
						}
					}
					if (ice >= 3 || board[i][j] == 0) {
						dump_board[i][j] = board[i][j];
					} else {
						dump_board[i][j] = board[i][j] - 1;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = dump_board[i][j];
//				dump_board[i][j] = 0;
			}
		}

	}

	static int bfs(int y, int x) {
		Queue<pair> q = new LinkedList<pair>();
		q.add(new pair(y, x));
		vis[y][x] = true;

		int sz = 0;
		while (!q.isEmpty()) {
			pair cur = q.poll();
			sz++;
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
					continue;
				}

				if (board[ny][nx] != 0 && vis[ny][nx] == false) {
					vis[ny][nx] = true;
					q.add(new pair(ny, nx));
				}
			}

		}
		return sz;
	}

	static void show() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		Q = stoi(st.nextToken());
		int n = (int) Math.pow(2, N);
		N = n;
		board = new int[n][n];
		dump_board = new int[n][n];
		vis = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = stoi(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int stage = stoi(st.nextToken());
			storm(stage);
			minus();

		}
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += board[i][j];
				if (vis[i][j] == false && board[i][j] != 0) {
					cnt = Math.max(cnt, bfs(i, j));
				}
			}
		}
		System.out.println(sum);
		System.out.println(cnt);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
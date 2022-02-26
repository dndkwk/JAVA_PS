package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_15683 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/*  */

	static int N, M;
	static int[][] board;
	static int[][] board2;
	static List<pair> cctv;
	static int answer = 100;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static void update(int y, int x, int dir) {
		dir %= 4;
		while (true) {
			x = x + dx[dir];
			y = y + dy[dir];
			if (x < 0 || x >= M || y < 0 || y >= N) {
				return;
			}
			if (board2[y][x] == 6) {
				return;
			}

			if (board2[y][x] != 0) {
				continue;
			}

			board2[y][x] = 7;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		board2 = new int[N][M];

		cctv = new ArrayList<pair>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] != 0 && board[i][j] != 6) {
					cctv.add(new pair(i, j));
				}
			}
		}

		int bf = (int) Math.pow(4, cctv.size());

		for (int k = 0; k < bf; k++) {

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					board2[i][j] = board[i][j];
				}
			}

			int temp = k;
			for (int i = 0; i < cctv.size(); i++) {
				int dir = temp % 4;
				temp /= 4;

				int y = cctv.get(i).y;
				int x = cctv.get(i).x;

				if (board[y][x] == 1) {
					update(y, x, dir);
				} else if (board[y][x] == 2) {
					update(y, x, dir);
					update(y, x, dir + 2);
				} else if (board[y][x] == 3) {
					update(y, x, dir);
					update(y, x, dir + 1);
				} else if (board[y][x] == 4) {
					update(y, x, dir);
					update(y, x, dir + 1);
					update(y, x, dir + 2);
				} else if (board[y][x] == 5) {
					update(y, x, dir);
					update(y, x, dir + 1);
					update(y, x, dir + 2);
					update(y, x, dir + 3);
				}

			}
			int val = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board2[i][j] == 0) {
						val++;
					}
				}
			}

			answer = Math.min(answer, val);
		}

		System.out.println(answer);

	}
}

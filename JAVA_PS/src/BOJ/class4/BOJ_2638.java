package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_2638 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M;
	static int[][] board;
	static int[][] cnt;
	static boolean[][] visited;
	static int result = 0;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	public static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void sol() {

		while (true) {
			if (check()) {
				break;
			}
			visited = new boolean[N][M];
			cnt = new int[N][M];
			Queue<pair> q = new LinkedList<pair>();
			q.add(new pair(0, 0));
			visited[0][0] = true;

			while (!q.isEmpty()) {
				pair cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
						continue;
					}

					if (visited[ny][nx] == false && board[ny][nx] == 0) {
						visited[ny][nx] = true;
						q.add(new pair(ny, nx));
					}

					if (board[ny][nx] == 1) {
						cnt[ny][nx]++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(cnt[i][j]>=2) {
						board[i][j]=0;
					}
				}
			}

			result++;
		}

	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sol();

		System.out.println(result);

	}
}


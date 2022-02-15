package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_7576 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정
	static int N, M, bfsvalue, nextvalue;
	static int[][] board;
	static boolean[][] visited;
	static Queue<pair> q;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	static void bfs(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
				continue;
			}
			if (board[ny][nx] == 0) {
				board[ny][nx] = 1;
				q.add(new pair(ny, nx));
				nextvalue++;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		visited = new boolean[N][M];
		q = new LinkedList<pair>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					q.add(new pair(i, j));
					visited[i][j] = true;
				}
			}
		}

		bfsvalue = q.size();
		nextvalue = 0;
		int answer = 0;

		while (!q.isEmpty()) {
			bfs(q.peek().y, q.peek().x);
			bfsvalue--;

			if (bfsvalue == 0) {
				bfsvalue = nextvalue;
				nextvalue = 0;
				answer++;
			}
			q.poll();
		}

		answer--;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					answer = -1;
				}
			}
		}

		System.out.println(answer);
		return;
	}

}

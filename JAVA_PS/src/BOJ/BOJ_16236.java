package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_16236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/*  */

	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int[] dy = { -1, 0, 0, 1 };
	static int[] dx = { 0, -1, 1, 0 };
	static Queue<tuple> q;

	static class tuple {
		int dist; // 상어와의 거리
		int y;
		int x;

		public tuple(int dist, int y, int x) {
			this.dist = dist;
			this.y = y;
			this.x = x;
		}
	}

	static void sol() {
		int siz = 2; // 사이즈
		int eat = 0; // 몇개 먹었는가
		int time = 0; // 시간

		while (true) {

			// 물고기 위치와 거리 계산해서 저장
			PriorityQueue<tuple> pq = new PriorityQueue<>((tuple t1, tuple t2) -> {
				if (t1.dist == t2.dist) {
					if (t1.y == t2.y) {
						return t1.x - t2.x;
					}
					return t1.y - t2.y;
				}
				return t1.dist - t2.dist;
			});

			// 전체 BFS로 돌면서 물고기들 거리와 위치 저장
			while (!q.isEmpty()) {
				tuple cur = q.poll();

				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					if (ny < 0 || ny >= N || nx < 0 || nx >= N)
						continue;
					if (board[ny][nx] > siz || visited[ny][nx] == true)
						continue;

					q.add(new tuple(cur.dist + 1, ny, nx));
					visited[ny][nx] = true;

					if (board[ny][nx] < siz && board[ny][nx] != 0) {
						pq.add(new tuple(cur.dist + 1, ny, nx));
					}
				}
			}

			// visited 초기화
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}

			// 물고기 먹기
			if (!pq.isEmpty()) {
				tuple cur = pq.poll();
				board[cur.y][cur.x] = 0;
				eat++;
				time = cur.dist;
				q.add(new tuple(cur.dist, cur.y, cur.x));
				visited[cur.y][cur.x] = true;
			} else {
				// 먹을 물고기가 없다
				System.out.println(time);
				break;
			}

			// 상어 사이즈 업
			if (eat == siz) {
				siz++;
				eat = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		visited = new boolean[N][N];
		q = new LinkedList<tuple>();

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) {
					q.add(new tuple(0, i, j));
					board[i][j] = 0;
					visited[i][j] = true;
				}
			}
		}

		sol();

	}
}

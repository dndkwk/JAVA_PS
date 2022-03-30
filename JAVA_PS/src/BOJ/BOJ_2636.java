package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_2636 {
	static int N, M;
	static int[][] board;
	static int[] dx = { 0, 0, -1, 1 };
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int cheese=0;
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==1) {
					cheese++;
				}
			}
		}
		int cnt=0;
		ArrayList<Integer> arr=new ArrayList<>();
		arr.add(cheese);
		while (!check()) {
			cnt++;
			arr.add(cheese);
			boolean[][] visited = new boolean[N][M];
			Queue<pair> q = new LinkedList<>();
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
					if (!visited[ny][nx] && board[ny][nx] == 1) {
						board[ny][nx]=0;
						cheese--;
						visited[ny][nx]=true;
					}

					if (!visited[ny][nx] && board[ny][nx] == 0) {
						visited[ny][nx]=true;
						q.add(new pair(ny,nx));
					}
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(arr.get(cnt));
		
	}
}
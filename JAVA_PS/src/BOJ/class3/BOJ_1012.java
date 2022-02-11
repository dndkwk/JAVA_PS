package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_1012 {

	static int[][] farm= new int[51][51];
	static boolean[][] visited= new boolean[51][51];
	static int N, M, K;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Pair {
		int x;
		int y;

		Pair(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	static void sol(int n, int m) {
		Queue<Pair> q = new LinkedList<Pair>();

		q.add(new Pair(n, m));

		while (!q.isEmpty()) {
			int y = q.peek().y;
			int x = q.peek().x;
			q.poll();
			

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 50 || nx < 0 || ny >= 50 || ny < 0) {
					continue;
				}
				if (farm[ny][nx] == 1 && visited[ny][nx] == false) {
					q.add(new Pair(ny, nx));
					visited[ny][nx] = true;
				}

			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			for(int[] a: farm) {
				Arrays.fill(a,0);
			}
			for(boolean[] a: visited) {
				Arrays.fill(a,false);
			}
			
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				farm[Y][X] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (farm[i][j] == 1 && visited[i][j] == false) {
						sol(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);

		}

	}

}

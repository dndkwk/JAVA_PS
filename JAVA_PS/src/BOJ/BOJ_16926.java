package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16926 {
	static int[][] board;
	static boolean[][] visited;

	static int[] dy = { 1, 0, -1, 0 }; // D R U L
	static int[] dx = { 0, 1, 0, -1 };
	static int N, M, R;
	static int temp;

	static void swap(int y1, int x1, int y2, int x2) {
		int value=board[y2][x2];
		board[y2][x2] = temp;
		temp=value;
	}

	static void sol(int n, int m) {
		int y = n;
		int x = m;
		visited[n][m] = true;
		temp = board[n][m];

		for (int i = 0; i < 4; i++) {
			while (true) {
				if (y + dy[i] < 0 || y + dy[i] >= N || x + dx[i] < 0 || x + dx[i] >= M) {
					break;
				}
				if (visited[y + dy[i]][x + dx[i]] == true) {
					break;
				}
				y = y + dy[i];
				x = x + dx[i];
				visited[y][x] = true;
				swap(y - dy[i], x - dx[i], y, x);
			}
		}
		
		board[n][m]=temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < R; r++) {
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] == false) {
						sol(i, j);
					}
				}
			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}
}

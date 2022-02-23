package SWEA;

import java.io.*;
import java.util.*;

public class Solution_1861 {

	static int[][] board;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N;
	static int cnt;

	static class pair {
		int y;
		int x;

		pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void sol(int n, int m) {
		Stack<pair> s = new Stack<>();
		s.add(new pair(n, m));

		while (!s.empty()) {
			int y = s.peek().y;
			int x = s.peek().x;
			s.pop();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				if (board[ny][nx] == (board[y][x] + 1)) {
					s.add(new pair(ny, nx));
					cnt++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			board = new int[N][N];
			int result = 0;
			int value = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 1;
					sol(i, j);
					if (result < cnt) {
						result = cnt;
						value = board[i][j];
					}else if(result ==cnt){
						value = Math.min(value, board[i][j]);
					}
				}
			}

			System.out.println("#" + t + " " + value + " " + result);

		}

	}

}

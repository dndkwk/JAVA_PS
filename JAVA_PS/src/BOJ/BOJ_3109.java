package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_3109 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/**/

	static int R, C;
	static int[][] board;
	static int cnt = 0;
	static int[] dx = { 1, 1, 1 };
	static int[] dy = { -1, 0, 1 };

	static boolean sol(int y, int x) {
		if (x == C - 1) {
			cnt++;
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
				continue;
			}
			if (board[ny][nx]==1) {
				continue;
			}
			board[ny][nx] = 1;

			if (sol(ny, nx)) {
				return true;
			}
		}

		return false;

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new int[R][C];

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				if (temp.charAt(j) == 'x') {
					board[i][j] = 1;
				} else {
					board[i][j] = 0;
				}
			}
		}
		
		
		for (int i = 0; i < R; i++) {
			sol(i, 0);
		}

		System.out.println(cnt);

	}
}

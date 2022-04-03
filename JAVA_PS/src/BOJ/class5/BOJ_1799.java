package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_1799 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[][] board;
	static int[] bishop = new int[2];
	static boolean[] visited1;
	static boolean[] visited2;

	static void sol(int cnt, int y, int x, int color) {
		if (x >= N) {
			y++;
			if (x % 2 == 0) {
				x = 1;
			} else {
				x = 0;
			}
		}

		if (y >= N) {
			if (cnt > bishop[color])
				bishop[color] = cnt;
			return;
		}

		if (board[y][x] == 1 && !visited1[x + y + 1] && !visited2[x - y + N]) {
			visited1[x + y + 1] = true;
			visited2[x - y + N] = true;
			sol(cnt + 1, y, x + 2, color);
			visited1[x + y + 1] = false;
			visited2[x - y + N] = false;
		}

		sol(cnt, y, x + 2, color);

	}

	public static void main(String[] args) throws Exception {
		N = stoi(br.readLine());
		board = new int[N][N];
		visited1 = new boolean[N * 2];
		visited2 = new boolean[N * 2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = stoi(st.nextToken());
			}
		}

		sol(0, 0, 0, 0);
		sol(0, 0, 1, 1);
		System.out.println(bishop[0]+bishop[1]);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

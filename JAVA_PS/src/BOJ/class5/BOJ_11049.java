package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_11049 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M;
	static int[][] dp;
	static int[][] board;

	static void sol() {
		for (int i = 1; i < N; i++) {
			for (int j = 0; j+i < N; j++) {
				dp[j][i + j] = 987654321;
				for (int k = 0; k < i; k++) {
					dp[j][j + i] = Math.min(dp[j][j + i],
							dp[j][j + k] + dp[j + k + 1][i + j] + board[j][0] * board[j + k][1] * board[i + j][1]);
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		dp = new int[N][N];
		board = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[i][0] = r;
			board[i][1] = c;
		}
		sol();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println("");
//		}

		System.out.println(dp[0][N - 1]);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

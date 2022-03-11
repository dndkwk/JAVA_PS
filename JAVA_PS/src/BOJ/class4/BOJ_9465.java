package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_9465 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[][] dp;
	static int[][] board;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			dp = new int[2][N + 1];
			board = new int[2][N + 1];
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for (int i = 1; i <= N; i++) {
					board[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][1] = board[0][1];
			dp[1][1] = board[1][1];
			for (int i = 2; i <= N; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], (i > 2) ? dp[1][i - 2] : 0) + board[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], (i > 2) ? dp[0][i - 2] : 0) + board[1][i];
			}

			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}

	}
}

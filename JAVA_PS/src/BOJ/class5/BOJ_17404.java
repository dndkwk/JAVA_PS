package BOJ.class5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	//

	static int N;
	static int[][] house;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		N = stoi(br.readLine());

		house = new int[N + 1][3];
		dp = new int[N + 1][3];
		int[] ans = new int[3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			house[i][0] = stoi(st.nextToken());
			house[i][1] = stoi(st.nextToken());
			house[i][2] = stoi(st.nextToken());
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					dp[1][j] = house[1][j];
				} else {
					dp[1][j] = 1001;
				}
			}

			for (int k = 2; k <= N; k++) {
				dp[k][0] = house[k][0] + Math.min(dp[k - 1][2], dp[k - 1][1]);
				dp[k][1] = house[k][1] + Math.min(dp[k - 1][0], dp[k - 1][2]);
				dp[k][2] = house[k][2] + Math.min(dp[k - 1][0], dp[k - 1][1]);
				if (k == N) {
					if (i == 0) {
						ans[i] = Math.min(dp[N][1], dp[N][2]);
					}
					if (i == 1) {
						ans[i] = Math.min(dp[N][0], dp[N][2]);
					}
					if (i == 2) {
						ans[i] = Math.min(dp[N][1], dp[N][0]);
					}
				}

			}

		}
		System.out.println(Math.min(ans[0], Math.min(ans[1], ans[2])));

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}

}

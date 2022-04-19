package Atcoder.Beginner.contest248;


import java.util.*;
import java.io.*;

public class C {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N, M, K;
	static int MOD = 998244353;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		long[][] dp = new long[N+1][K+1];

		for (int i = 1; i <= M; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= K; j++) {
				for (int k = 1; k <= M; k++) {
					if (j-k >=0) {
						dp[i][j]+=dp[i-1][j-k];
						dp[i][j]%=MOD;
					}
				}
			}
		}
//		for(int i=1;i<=K;i++) {
//			System.out.print(dp[1][i]+" ");
//		}
//		System.out.println("");

		long sum = 0;
		for (int i = 1; i <= K; i++) {
			sum = (sum + dp[N][i]) % MOD;
		}
		System.out.println(sum);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}


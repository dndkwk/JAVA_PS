package Atcoder.Beginner.contest245;

import java.io.*;
import java.util.*;

public class C {

	static int N, K;
	static int[] a;
	static int[] b;
	static boolean[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		a = new int[N];
		b = new int[N];
		dp = new boolean[2][N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		dp[0][0] = true;
		dp[1][0] = true;

		for (int i = 0; i < N - 1; i++) {
			if (dp[0][i] == true) {
				if(Math.abs(a[i]-a[i+1])<=K) {
					dp[0][i+1]=true;
				}
				
				if(Math.abs(a[i]-b[i+1])<=K) {
					dp[1][i+1]=true;
				}
			}

			if (dp[1][i] == true) {
				if(Math.abs(b[i]-a[i+1])<=K) {
					dp[0][i+1]=true;
				}
				
				if(Math.abs(b[i]-b[i+1])<=K) {
					dp[1][i+1]=true;
				}
			}
		}
		
		if(dp[0][N-1] || dp[1][N-1] ) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}

}

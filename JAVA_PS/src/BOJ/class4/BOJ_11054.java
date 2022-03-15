package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_11054 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] max_dp = new int[N];
		int[] min_dp = new int[N];
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			max_dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					max_dp[i] = Math.max(max_dp[i], max_dp[j] + 1);
				}
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			min_dp[i] = 1;
			for (int j = N - 1; j > i; j--) {
				if (arr[i] > arr[j]) {
					min_dp[i] = Math.max(min_dp[i], min_dp[j] + 1);
				}
			}
		}
		
		int result=0;
		for(int i = 0; i < N; i++) {
			result=Math.max(result, min_dp[i]+max_dp[i]-1);
		}
		System.out.println(result);
	}
}


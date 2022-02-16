package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_9095 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정

	
	public static void main(String[] args) throws Exception {
		int T=Integer.parseInt(br.readLine());
		int[] dp=new int[12];
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		dp[4]=7;
		for(int i=5;i<12;i++) {
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
		
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
		

		return;
	}

}

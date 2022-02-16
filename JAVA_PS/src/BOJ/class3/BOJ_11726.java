package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_11726 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정
	
	public static void main(String[] args) throws Exception {
		int N=Integer.parseInt(br.readLine());
		
		int[] dp=new int[1001];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=N;i++) {
			dp[i]=(dp[i-1]+dp[i-2])%10007;
		}
		
		System.out.println(N==1 ? 1 :dp[N]);
		
		return;
	}

}


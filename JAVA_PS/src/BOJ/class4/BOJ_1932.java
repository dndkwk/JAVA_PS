package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_1932 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		int[][] dp=new int[N+1][N+1];
		int[][] value=new int[N+1][N+1];
		
		
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++) {
				value[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=value[i][j]+Math.max(dp[i-1][j],dp[i-1][j-1]);
			}
		}
		int result=0;
		for(int i=1;i<=N;i++) {
			result=Math.max(result, dp[N][i]);
		}
		
		System.out.println(result);

	}
}


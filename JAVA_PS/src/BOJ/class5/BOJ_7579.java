package BOJ.class5;
import java.util.*;
import java.io.*;

public class BOJ_7579 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M;
	static int[] app;
	static int[] c;
	static int[][] dp;
	static class pair{
		int m;
		int cost;
		public pair(int m, int cost) {
			super();
			this.m = m;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		app=new int[N];
		c=new int[N];
		dp=new int[N][10001];
		int ans=Integer.MAX_VALUE;
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			app[i]=stoi(st.nextToken());
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			c[i]=stoi(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			int memory=app[i];
			int cost=c[i];
			
			for(int j=0;j<=10000;j++) {
				if(i==0) {
					if(j>=cost) {
						dp[i][j]=memory;
					}
				}else {
					if(j>=cost) {
						dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-cost]+memory);
					}else {
						dp[i][j]=dp[i-1][j];
					}
				}
				if(dp[i][j] >= M) {
					ans=Math.min(ans, j);
				}
				
			}
		}
		System.out.println(ans);
	}
	

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

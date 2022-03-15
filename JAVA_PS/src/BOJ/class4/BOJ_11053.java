package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_11053 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	
	

	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr=new int[N];
		int[] dp=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[j]+1,dp[i] );
				}
			}
		}
		int result=0;
		for(int i=0;i<N;i++) {
			result=Math.max(result, dp[i]);
		}
		
		System.out.println(result);
	}
}

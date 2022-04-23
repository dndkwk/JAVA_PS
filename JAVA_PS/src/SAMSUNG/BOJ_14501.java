package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_14501 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[] dp;
	static pair[] board;
	static class pair{
		int day;
		int value;
		public pair(int day, int value) {
			super();
			this.day = day;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws Exception {
		N=stoi(br.readLine());
		board=new pair[N];
		dp=new int[N+1];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			board[i]=new pair(stoi(st.nextToken()),stoi(st.nextToken()));
		}
		for(int i=0;i<N;i++) {
			if(i+board[i].day <=N) {
				dp[i+board[i].day]=Math.max(dp[i+board[i].day], dp[i]+board[i].value);
			}
			dp[i+1]=Math.max(dp[i+1], dp[i]);
		}
		System.out.println(dp[N]);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

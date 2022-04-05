package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_2098 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[][] board;
	static int[][] dp;
	static final int INF=987654321;
	
	static int sol(int cur,int flag) {
		if(flag == (1<<N)-1) {
			if(board[cur][0]==0) {
				return INF;
			}
			return board[cur][0];
		}
		
		if(dp[cur][flag] != INF) {
			return dp[cur][flag];
		}
		
		for(int i=0;i<N;i++) {
			if((flag & (1<<i))==0 && board[cur][i]!=0) {
				dp[cur][flag]=Math.min(dp[cur][flag], sol(i,flag | (1<<i))+board[cur][i]);
			}
		}
		
		
		return dp[cur][flag];
	}
	
	public static void main(String[] args) throws Exception {
		//st = new StringTokenizer(br.readLine());
		N=stoi(br.readLine());
		board=new int[N][N];
		dp=new int[N][(1<<N)-1];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j]=stoi(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			Arrays.fill(dp[i], INF);
		}
		
		System.out.println(sol(0,1));
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

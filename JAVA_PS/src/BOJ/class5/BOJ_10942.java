package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_10942 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M;
	static int[] board;
	static boolean[][] dp;
	public static void sol() {
		for(int i=0;i<N;i++) {
			dp[i][i]=true;
		}
		for(int i=0;i<N-1;i++) {
			if(board[i]==board[i+1]) {
				dp[i][i+1]=true;
			}
		}
		for(int i=2;i<N;i++) {
			for(int j=0;j<N-i;j++) {
				if(board[j]==board[j+i] &&dp[j+1][j+i-1]) {
					dp[j][j+i]=true;
				}
			}			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		board=new int[N];
		dp=new boolean[N][N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			board[i]=stoi(st.nextToken());
		}
		sol();
		M=stoi(br.readLine());
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int S=stoi(st.nextToken())-1;
			int E=stoi(st.nextToken())-1;
			if(dp[S][E]) {
				sb.append(1+"\n");				
			}else {
				sb.append(0+"\n");
			}
		}
		
		System.out.println(sb);
		
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

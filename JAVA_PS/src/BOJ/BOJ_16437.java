package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_16437 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static List<Integer>[] board;
	static long[] dp;
	
	public static void sol(int idx,int pa){
		for(int nxt:board[idx]) {
			sol(nxt,idx);
		}
		if(pa!=-1) {
			if(dp[idx]>0) {
				dp[pa]+=dp[idx];
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		board=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			board[i]=new ArrayList<>();
		}
		
		dp=new long[N+1];
		for(int i=2;i<N+1;i++) {
			String[] temp=br.readLine().split(" ");
			
			board[Integer.parseInt(temp[2])].add(i);
			if(temp[0].equals("W")) {
				dp[i]=-Integer.parseInt(temp[1]);
			}else {
				dp[i]=Integer.parseInt(temp[1]);
			}
		}
		
		sol(1,-1);
		System.out.println(dp[1]);
	}
}

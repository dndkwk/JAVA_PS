package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_14889 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[][] board;
	static boolean[] vis;
	static int ans=Integer.MAX_VALUE;
	static void sol(int cnt,int start) {
		if(cnt==N/2) {
			ArrayList<Integer> A=new ArrayList<>();
			ArrayList<Integer> B=new ArrayList<>();
			for(int i=0;i<N;i++) {
				if(vis[i]) {
					A.add(i);
				}else {
					B.add(i);
				}
			}
			int A_sum=0;
			for(int i=0;i<A.size();i++) {
				for(int j=0;j<A.size();j++) {
					A_sum+=board[A.get(i)][A.get(j)];
				}				
			}
			
			int B_sum=0;
			for(int i=0;i<B.size();i++) {
				for(int j=0;j<B.size();j++) {
					B_sum+=board[B.get(i)][B.get(j)];
				}				
			}
			
			
			ans=Math.min(ans, Math.abs(A_sum-B_sum));
			return ;
		}
		
		for(int i=start;i<N;i++) {
			vis[i]=true;
			sol(cnt+1,i+1);
			vis[i]=false;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		N=stoi(br.readLine());
		board=new int[N][N];
		vis=new boolean[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j]=stoi(st.nextToken());
			}			
		}
		
		sol(0,0);
		
		System.out.println(ans);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

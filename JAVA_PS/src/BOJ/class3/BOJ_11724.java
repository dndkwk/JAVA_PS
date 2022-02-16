package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_11724 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정
	static boolean[] visited;
	static int[][] board;
	static int N;
	
	static void sol(int idx) {
		visited[idx]=true;
		
		for(int i=0;i<N;i++) {
			if(board[idx][i]==1 && visited[i]==false) {
				sol(i);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		board=new int[N][N];
		visited=new boolean[N];
		int cnt=0;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken())-1;
			int v=Integer.parseInt(st.nextToken())-1;
			board[u][v]=1;
			board[v][u]=1;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i]==false) {
				sol(i);
				cnt++;
			}
		}
		System.out.println(cnt);
		
		return;
	}

}

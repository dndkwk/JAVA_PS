package SWEA;

import java.io.*;
import java.util.*;

public class Solution_7465 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/*  */

	static int N,M;
	static int[][] board;
	static boolean[] visited;

	static void sol(int n) {
		Queue<Integer> q=new LinkedList<Integer>();
		visited[n]=true;
		q.add(n);
		
		while(!q.isEmpty()) {
			int nxt=q.poll();
			
			for(int i=0;i<=N;i++) {
				if(board[nxt][i]==1 && visited[i]==false) {
					visited[i]=true;
					q.add(i);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			board=new int[N+1][N+1];
			visited=new boolean[N+1];
			int cnt=0;
			
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int u=Integer.parseInt(st.nextToken());
				int v=Integer.parseInt(st.nextToken());
				board[u][v]=1;
				board[v][u]=1;
			}
			
			for(int i=1;i<=N;i++) {
				if(!visited[i]) {
					cnt++;
					sol(i);
				}
			}
			
			System.out.println("#"+t+" "+cnt);
			
		}

	}
}

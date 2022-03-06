package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_1967 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,start=0;
	static ArrayList<ArrayList<pair>> board;
	static int mx=0;
	static boolean[] visited;
	
	static class pair{
		int x;
		int cost;
		public pair(int x, int cost) {
			super();
			this.x = x;
			this.cost = cost;
		}
	}
	
	static public void dfs(int node,int cost) {
		if(visited[node]==true) {
			return;
		}
		visited[node]=true;
		if(mx < cost) {
			mx=cost;
			start=node;
		}
		
		for(int i=0;i<board.get(node).size();i++) {
			dfs(board.get(node).get(i).x,cost+board.get(node).get(i).cost);
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		
		board=new ArrayList<ArrayList<pair>>();
		for(int i=0;i<=N;i++) {
			board.add(new ArrayList<pair>());
		}
		
		
		for(int i=1;i<=N-1;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			board.get(from).add(new pair(to,cost));
			board.get(to).add(new pair(from,cost));
		}
		
		mx=0;
		visited=new boolean[N+1];
		dfs(1,0);
		
		mx=0;
		visited=new boolean[N+1];
		dfs(start,0);
		
		System.out.println(mx);
	}
}

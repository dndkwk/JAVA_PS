package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_11725 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static ArrayList<ArrayList<Integer>> board;
	static int[] parent;
	static boolean[] visited;
	
	public static void sol(int num) {
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(num);
		
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			
			for(int i=0;i<board.get(cur).size();i++) {
				int nxt=board.get(cur).get(i);
				if(visited[nxt]==false) {
					visited[nxt]=true;
					parent[nxt]=cur;
					q.add(nxt);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		
		board=new ArrayList<ArrayList<Integer>>();
		parent=new int[N+1];
		visited=new boolean[N+1];
		
		for(int i=0;i<N+1;i++) {
			board.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<N-1;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			board.get(u).add(v);
			board.get(v).add(u);
		}
		
		sol(1);
		
		for(int i=2;i<=N;i++) {
			sb.append(parent[i]+"\n");
		}
		
		System.out.println(sb);
		
	}
}

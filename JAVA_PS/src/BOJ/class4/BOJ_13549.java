package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_13549 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,K;
	static boolean[] visited;
	
	static class pair{
		int n;
		int cnt;
		public pair(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		visited=new boolean[100001];
		PriorityQueue<pair> q=new PriorityQueue<pair>((p1,p2)-> {return p1.cnt-p2.cnt;});
		visited[N]=true;
		q.add(new pair(N,0));
		int mn=0;
		
		while(!q.isEmpty()) {
			pair cur=q.poll();
			visited[cur.n]=true;
			
			if(mn==0 && cur.n==K) {
				mn=cur.cnt;
				break;
			}
			
			if(cur.n-1 >=0 && visited[cur.n-1]==false) {
				q.add(new pair(cur.n-1,cur.cnt+1));
			}
			
			if(cur.n+1 <=100000 && visited[cur.n+1]==false) {
				q.add(new pair(cur.n+1,cur.cnt+1));
			}
			if(cur.n*2 <=100000 && visited[cur.n*2]==false) {
				q.add(new pair(cur.n*2,cur.cnt));
			}
			
		}
		System.out.println(mn);
		
	}
}


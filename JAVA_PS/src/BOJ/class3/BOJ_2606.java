package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_2606 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정
	static int N;
	
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		
		N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] arr=new ArrayList[N+1];
		visited=new boolean[N+1];
		
		for(int i=0;i<N+1;i++) {
			 arr[i]=new ArrayList<Integer>();
		}
		
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(1);
		visited[1]=true;
		int cnt=0;
		while(!q.isEmpty()) {
			int nxt=q.poll();
			
			for(int x:arr[nxt]) {
				if(visited[x]==false) {
					visited[x]=true;
					q.add(x);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		return;
	}

}

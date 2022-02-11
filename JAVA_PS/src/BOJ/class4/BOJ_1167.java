package BOJ.class4;

import java.io.*;
import java.util.*;

public class BOJ_1167 {
	
	static int V;
	static ArrayList<pair>[] tree;
	static boolean[] visited;
	static int pivot=0;
	static int len=0;
	
	static class pair{
		int n;
		int cost;
		pair(int n,int cost){
			this.n=n;
			this.cost=cost;
		}
	}
	
	public static void dfs(int n,int cost) {
		if(visited[n]) {
			return;
		}
		
		visited[n]=true;
		if(len < cost) {
			len=cost;
			pivot=n;
		}
		
		for(int i=0;i<tree[n].size();i++){
			dfs(tree[n].get(i).n,cost+tree[n].get(i).cost);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st = null;
		V=Integer.parseInt(br.readLine());
		tree=new ArrayList[V+1];
		
		for(int i=0;i<V+1;i++) {
			tree[i]=new ArrayList<>();
		}
		
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			while(true) {
				int m=Integer.parseInt(st.nextToken());
				if(m==-1) {
					break;
				}
				int cost=Integer.parseInt(st.nextToken());
				tree[n].add(new pair(m,cost));
			}
		}
		
		visited=new boolean[V+1];
		dfs(1,0);
		
		len=0;
		visited=new boolean[V+1];
		dfs(pivot,0);
		System.out.println(len);
		return;

	}
}

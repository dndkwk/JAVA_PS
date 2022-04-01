package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_1647 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N, M;
	static int[] parents;
	static class pair {
		int u;
		int v;
		int cost;

		public pair(int u, int v, int cost) {
			super();
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
	}
	
	static int find(int x) {
		if(x==parents[x]) {
			return x;
		}
		return parents[x]=find(parents[x]);
	}
	
	static boolean union(int x,int y) {
		int a=find(x);
		int b=find(y);
		if(a==b) {
			return false;
		}
		parents[a]=b;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		parents=new int[N+1];
		for(int i=0;i<=N;i++) {
			parents[i]=i;
		}
		PriorityQueue<pair> pq = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = stoi(st.nextToken());
			int B = stoi(st.nextToken());
			int C = stoi(st.nextToken());
			pq.add(new pair(A,B,C));
		}
		
		ArrayList<Integer> result=new ArrayList<>();
		while(!pq.isEmpty()) {
			pair cur=pq.poll();
			if(union(cur.v,cur.u)) {
				result.add(cur.cost);
			}
		}
		
		int sum=0;
		for(int i=0;i<result.size()-1;i++) {
			sum+=result.get(i);
		}
		System.out.println(sum);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

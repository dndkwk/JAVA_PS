package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_2887 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[] parents;
	static class pair {
		int idx;
		int x;
		int y;
		int z;

		public pair(int idx, int x, int y, int z) {
			super();
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static class node {
		int u;
		int v;
		int cost;

		public node(int u, int v, int cost) {
			super();
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
	}
	
	static int find(int x) {
		if(x==parents[x])return x;
		
		return parents[x]=find(parents[x]);
	}
	
	static boolean union(int y,int x) {
		y=find(y);
		x=find(x);
		if(x==y) {
			return false;
		}
		parents[y]=Math.min(y, x);
		parents[x]=Math.min(y, x);
		
		return true;
	}

	public static void main(String[] args) throws Exception {
		N = stoi(br.readLine());
		pair[] board = new pair[N];
		parents=new int[N];
		for(int i=0;i<N;i++) {
			parents[i]=i;
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken());
			int y = stoi(st.nextToken());
			int z = stoi(st.nextToken());
			board[i] = new pair(i, x, y, z);
		}
		PriorityQueue<node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);

		Arrays.sort(board, (p1, p2) -> p1.x - p2.x);
		for (int i = 0; i < N - 1; i++) {
			pq.add(new node(board[i].idx, board[i + 1].idx, Math.abs(board[i].x - board[i + 1].x)));
		}
		Arrays.sort(board, (p1, p2) -> p1.y - p2.y);
		for (int i = 0; i < N - 1; i++) {
			pq.add(new node(board[i].idx, board[i + 1].idx, Math.abs(board[i].y - board[i + 1].y)));
		}
		Arrays.sort(board, (p1, p2) -> p1.z - p2.z);
		for (int i = 0; i < N - 1; i++) {
			pq.add(new node(board[i].idx, board[i + 1].idx, Math.abs(board[i].z - board[i + 1].z)));
		}
		long sum=0;
		while(!pq.isEmpty()) {
			node cur=pq.poll();
			if(union(cur.u, cur.v)) {
				sum+=cur.cost;
			}
		}
		
		System.out.println(sum);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

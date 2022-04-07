package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_4386 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[] parents;

	static class pair {
		int idx;
		double x;
		double y;

		public pair(int idx, double x, double y) {
			super();
			this.idx = idx;
			this.x = x;
			this.y = y;
		}
	}

	static class node {
		int u;
		int v;
		double cost;

		public node(int u, int v, double cost) {
			super();
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
	}

	static int find(int x) {
		if (x == parents[x])
			return x;

		return parents[x] = find(parents[x]);
	}

	static boolean union(int y, int x) {
		y = find(y);
		x = find(x);
		if (x == y) {
			return false;
		}
		parents[y] = Math.min(y, x);
		parents[x] = Math.min(y, x);

		return true;
	}

	public static void main(String[] args) throws Exception {
		N = stoi(br.readLine());
		pair[] board = new pair[N];
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			board[i] = new pair(i, x, y);
		}

		PriorityQueue<node> pq = new PriorityQueue<>((n1, n2) -> {
			if (n1.cost > n2.cost) {
				return 1;
			}else {
				return -1;
			}
		});

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				double temp = Math.pow(board[i].x - board[j].x, 2) + Math.pow(board[i].y - board[j].y, 2);
				pq.add(new node(i, j, Math.sqrt(temp)));
			}
		}
		double sum=0;
		while(!pq.isEmpty()) {
			node cur=pq.poll();
			if(union(cur.u,cur.v)) {
				sum+=cur.cost;
			}
		}
		System.out.println(sum);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

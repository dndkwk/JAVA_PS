package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_11779 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M;
	static ArrayList<ArrayList<pair>> board;
	static int[] cost;
	static int[] trace;
	static boolean[] visited;
	static int INF = 987654321;

	static class pair {
		int node;
		int c;

		public pair(int node, int c) {
			this.node = node;
			this.c = c;
		}
	}

	public static void sol(int num) {
		PriorityQueue<pair> pq = new PriorityQueue<>((p1, p2) -> {
			return p1.c - p2.c;
		});
		pq.add(new pair(num, 0));
		cost[num] = 0;
		while (!pq.isEmpty()) {
			pair cur = pq.poll();

			if (cost[cur.node] < cur.c) {
				continue;
			}
			for (pair p : board.get(cur.node)) {
				int nxt = p.node;
				int cc = p.c;
				if (cost[nxt] > cur.c + cc) {
					cost[nxt] = cur.c + cc;
					trace[nxt] = cur.node;
					pq.add(new pair(nxt, cur.c + cc));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		cost = new int[N + 1];
		visited = new boolean[N + 1];
		trace= new int[N + 1];
		Arrays.fill(cost, INF);
		board = new ArrayList<ArrayList<pair>>();

		for (int i = 0; i <= N; i++) {
			board.add(new ArrayList<pair>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board.get(u).add(new pair(v, c));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		sol(start);
		sb.append(cost[end]+"\n");
		int n=end;
		ArrayList<Integer> route=new ArrayList<Integer>();
		while(n!=0) {
			route.add(n);
			n=trace[n];
		}
		sb.append(route.size()+"\n");
		for(int i=route.size()-1;i>=0;i--) {
			sb.append(route.get(i)+" ");
		}
		System.out.println(sb);

	}
}

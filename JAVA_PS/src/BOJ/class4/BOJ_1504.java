package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_1504 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N, E, X;
	static ArrayList<ArrayList<pair>> board;

	static class pair {
		int x;
		int cost;

		public pair(int x, int cost) {
			super();
			this.x = x;
			this.cost = cost;
		}
	}

	static int[] sol(int start) {
		int[] cost = new int[N + 1];
		Arrays.fill(cost, 987654321);
		cost[start] = 0;
		PriorityQueue<pair> pq = new PriorityQueue<>((p1, p2) -> {
			return p1.cost - p2.cost;
		});
		pq.add(new pair(start, 0));

		while (!pq.isEmpty()) {
			pair cur = pq.poll();

			if (cost[cur.x] < cur.cost) {
				continue;
			}

			for (int i = 0; i < board.get(cur.x).size(); i++) {
				pair nxt = board.get(cur.x).get(i);
				if (cost[nxt.x] > cur.cost + nxt.cost) {
					cost[nxt.x] = cur.cost + nxt.cost;
					pq.add(new pair(nxt.x, cur.cost + nxt.cost));
				}
			}
		}

		return cost;

	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		board = new ArrayList<ArrayList<pair>>();

		for (int i = 0; i <= N; i++) {
			board.add(new ArrayList<pair>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			board.get(u).add(new pair(v, t));
			board.get(v).add(new pair(u, t));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int[] temp1 = sol(1);
		int[] temp2 = sol(v1);
		int[] temp3 = sol(v2);
		
		int result =Math.min(temp1[v1] + temp2[v2] + temp3[N], temp1[v2] + temp2[N] + temp3[v1]);
		
		if (result > 987654321 || result < 0) {
			result=-1;
		}

		System.out.println(result);
	}
}

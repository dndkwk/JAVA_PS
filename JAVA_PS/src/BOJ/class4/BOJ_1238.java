package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_1238 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N, M, X;
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
				pair nxt=board.get(cur.x).get(i);
				if(cost[nxt.x] > cur.cost+nxt.cost) {
					cost[nxt.x]=cur.cost+nxt.cost;
					pq.add(new pair(nxt.x,cur.cost+nxt.cost));
				}
			}
		}

		return cost;

	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		board = new ArrayList<ArrayList<pair>>();

		for (int i = 0; i <= N; i++) {
			board.add(new ArrayList<pair>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			board.get(u).add(new pair(v,t));
		}

		int result = -1;

		for (int i = 0; i <= N; i++) {
			int[] temp1 = sol(i);
			int[] temp2 = sol(X);
			if (temp1[X] + temp2[i] >= 987654321) {
				continue;
			}

			result = Math.max(result, temp1[X] + temp2[i]);
		}
		System.out.println(result);
	}
}


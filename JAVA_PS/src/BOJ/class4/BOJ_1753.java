package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_1753 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int V, E, K;
	static ArrayList<ArrayList<pair>> board;
	static int INF=987654321;

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
		int[] cost = new int[V + 1];
		Arrays.fill(cost, INF);
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
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());

		board = new ArrayList<ArrayList<pair>>();

		for (int i = 0; i <= V; i++) {
			board.add(new ArrayList<pair>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			board.get(u).add(new pair(v,t));
		}
		
		int[] temp=sol(K);
		
		for(int i=1;i<=V;i++) {
			if(temp[i]==INF) {
				sb.append("INF\n");
			}else {
				sb.append(temp[i]+"\n");
			}
		}
		
		
		System.out.println(sb.toString());

		
	}
}


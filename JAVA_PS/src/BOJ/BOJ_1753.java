package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/*  */
	static int V, E, K;
	static ArrayList<ArrayList<pair>> board;
	static int[] dist;
	static boolean[] visited;
	static final int INF = 987654321;

	static class pair {
		int cost;
		int x;

		public pair(int cost, int x) {
			super();
			this.cost = cost;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		board = new ArrayList<ArrayList<pair>>();
		for(int i=0;i<V+1;i++) {
			board.add(new ArrayList<pair>());
		}
		
		dist=new int[V+1];
		PriorityQueue<pair> pq = new PriorityQueue<>((p1, p2) -> {
			return p1.cost - p2.cost;
		});
		
		visited=new boolean[V+1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			board.get(u).add(new pair(w, v));
		}

		Arrays.fill(dist, INF);
		dist[K] = 0;
		pq.add(new pair(0,K));
		
		while(!pq.isEmpty()) {
			pair cur=pq.poll();
			
			if(visited[cur.x]) {
				continue;
			}
			visited[cur.x]=true;
			
			for(pair p: board.get(cur.x)) {
				int nxt=p.x;
				int cost=p.cost;
				if(dist[nxt] > dist[cur.x]+cost) {
					dist[nxt] = dist[cur.x]+cost;
					pq.add(new pair(dist[nxt],nxt));
				}
			}
		}
		
		for(int i=1;i<=V;i++) {
			if(dist[i]==INF) {
				sb.append("INF\n");
			}else {
				sb.append(dist[i]+"\n");
			}
		}
		
		System.out.println(sb);

	}
}

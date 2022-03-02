package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_1916 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M;
	static ArrayList<ArrayList<pair>> board;
	static int start, end;

	static class pair {
		int x;
		int cost;

		public pair(int x, int cost) {
			super();
			this.x = x;
			this.cost = cost;
		}
	}

	public static int sol() {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, 987564321);

		dist[start] = 0;
		PriorityQueue<pair> pq = new PriorityQueue<>((p1, p2) -> {
			return p1.cost - p2.cost;
		});
		pq.add(new pair(start,0));
		
		while(!pq.isEmpty()) {
			pair cur=pq.poll();
			
			if(dist[cur.x] < cur.cost) {
				continue;
			}
			
			for(int i=0;i<board.get(cur.x).size();i++) {
				pair nxt=board.get(cur.x).get(i);
				if(dist[nxt.x] > dist[cur.x]+nxt.cost) {
					dist[nxt.x] = cur.cost+nxt.cost;
					pq.add(new pair(nxt.x,dist[nxt.x]));
				}
			}
		}
		
		

		return dist[end];
	}

	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		board = new ArrayList<ArrayList<pair>>();
		for (int i = 0; i <= N; i++) {
			board.add(new ArrayList<pair>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board.get(s).add(new pair(e, c));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		System.out.println(sol());

	}
}


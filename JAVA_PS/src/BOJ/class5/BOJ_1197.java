package BOJ.class5;
import java.util.*;
import java.io.*;

public class BOJ_1197 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int V, E;
	static int[] parents;

	static class pair {
		int s;
		int e;
		int cost;

		public pair(int s, int e, int cost) {
			super();
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
	}

	public static int find(int x) {
		if (x == parents[x]) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return false;
		}
		parents[x] = y;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		long answer = 0;
		parents = new int[V + 1];
		int cnt = 0;
		for (int i = 0; i <= V; i++) {
			parents[i] = i;
		}
		PriorityQueue<pair> pq = new PriorityQueue<>((p1, p2) -> {
			return p1.cost - p2.cost;
		});

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			pq.add(new pair(A, B, C));
		}

		while (!pq.isEmpty()) {
			pair cur = pq.poll();
			if (union(cur.s, cur.e)) {
				answer += cur.cost;
			}
		}

		System.out.println(answer);
	}
}

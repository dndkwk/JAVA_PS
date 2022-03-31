package BOJ.class5;
import java.util.*;
import java.io.*;

public class BOJ_1202 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N, K;

	static class pair {
		int m;
		int v;

		public pair(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		pair[] jew = new pair[N];
		int[] bag = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = stoi(st.nextToken());
			int v = stoi(st.nextToken());
			jew[i] = new pair(m, v);
		}

		for (int i = 0; i < K; i++) {
			int c = stoi(br.readLine());
			bag[i] = c;
		}
		
		Arrays.sort(jew, (p1, p2) -> {
			return p1.m - p2.m;
		});
		Arrays.sort(bag);
		

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		long result = 0;
		int idx=0;
		
		for(int i=0;i<K;i++) {
			while(idx<N && jew[idx].m<=bag[i]) {
				
				pq.add(jew[idx].v);
				++idx;
			}
			if(!pq.isEmpty()) {
				result+=pq.poll();
			}
		}
		
		System.out.println(result);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

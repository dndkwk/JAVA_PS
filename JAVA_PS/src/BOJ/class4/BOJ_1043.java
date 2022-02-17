package BOJ.class4;

import java.io.*;
import java.util.*;

public class BOJ_1043 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/**/
	static int N, M;
	static List<Integer> know;
	static int[] parents;
	static List<Integer>[] v;

	static int find(int x) {
		if (parents[x] == x)
			return x;
		return x = find(parents[x]);

	}

	static void union(int u, int v) {
		u = find(u);
		v = find(v);

		parents[u] = v;

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		know = new ArrayList<Integer>();
		parents = new int[N + 1];
		v = new ArrayList[50];
		
		for (int i = 0; i <50; i++) {
			v[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) {
			know.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int num = 0;
			int prev = 0;
			for (int j = 0; j < p; j++) {
				if (j >= 1) {
					prev = num;
					num = Integer.parseInt(st.nextToken());
					union(prev, num);
				} else {
					num = Integer.parseInt(st.nextToken());
				}
				v[i].add(num);
			}
		}

		for (List<Integer> list : v) {
			boolean flag = false;
			for (int person : list) {
				for (int k : know) {
					if (find(person) == find(k)) {
						flag = true;
						break;
					}
				}
			}
			if (flag)
				M--;
		}

		System.out.println(M);
	}
}

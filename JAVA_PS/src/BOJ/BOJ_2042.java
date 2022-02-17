package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_2042 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정

	static int N, K, M;
	static Long[] arr;
	static Long[] tree;

	static Long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;
		return tree[node] = init(2 * node,start, mid) + init(2 * node + 1,mid + 1, end);

	}

	static long sum(int node, int L, int R, int nodeL, int nodeR) {
		if (nodeR < L || nodeL > R) {
			return 0;
		}
		if (nodeL<=L && R<=nodeR) {
			return tree[node];
		}

		int mid = (L + R) / 2;

		return sum(2 * node, L, mid, nodeL, nodeR) + sum(2 * node + 1,mid+1, R, nodeL, nodeR);

	}

	static void update(int node, int L, int R, int idx, long diff) {
		if (idx < L || idx > R)
			return;

		tree[node] += diff;
		if (L != R) {
			int mid = (L + R) / 2;
			update(2 * node, L, mid, idx, diff);
			update(2 * node + 1, mid + 1, R, idx, diff);
		}

	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new Long[N + 1];
		tree = new Long[4 * N];

		for (int i = 1; i <= N; i++) {
			Long temp = Long.parseLong(br.readLine());
			arr[i] = temp;
		}

		init(1, 1, N);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());

			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				long diff = c - arr[b];
				arr[b] = c;
				update(1, 1, N, b, diff);

			} else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				sb.append(sum(1, 1, N, b, c) + "\n");
			}
		}

		System.out.println(sb);

		return;
	}

}

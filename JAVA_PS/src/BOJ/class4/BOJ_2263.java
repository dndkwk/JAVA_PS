package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_2263 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int MAX = 100000 + 1;
	static int[] pre, in, post, idx;

	public static void sol(int inBegin, int inEnd, int postBegin, int postEnd) {
		if (inBegin > inEnd || postBegin > postEnd)

			return;

		int root = post[postEnd];
		sb.append(root + " ");

		// 왼쪽

		sol(inBegin, idx[root] - 1, postBegin, postBegin + (idx[root] - inBegin) - 1);

		// 오른쪽

		sol(idx[root] + 1, inEnd, postBegin + (idx[root] - inBegin), postEnd - 1);
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		pre = new int[MAX];
		in = new int[MAX];
		post = new int[MAX];
		idx = new int[MAX];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			idx[in[i]] = i;
		}

		sol(0, N - 1, 0, N - 1);
		
		System.out.println(sb);

	}
}

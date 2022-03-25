package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1949 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[] people;
	static int[][] dp;
	static ArrayList<ArrayList<Integer>> board;

	public static void sol(int cur, int parent) {
		for (int nxt : board.get(cur)) {
			if(nxt!=parent) {
				sol(nxt, cur);
				dp[cur][1] += dp[nxt][0];
				dp[cur][0] += Math.max(dp[nxt][0], dp[nxt][1]);
			}
		}
		dp[cur][1] += people[cur];

	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		dp = new int[N][2];
		board = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			board.add(new ArrayList<Integer>());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			board.get(u).add(v);
			board.get(v).add(u);
		}

		sol(0, -1);
		System.out.println(Math.max(dp[0][0], dp[0][1]));

	}
}

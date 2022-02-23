package SWEA;

import java.io.*;
import java.util.*;

public class Solution_3234 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/*  */
	static int T;
	static int N;
	static int[] arr;
	static int[] perm;
	static int answer;

	static void sol(int cnt, int left_sum, int right_sum) {
		if (left_sum < right_sum) {
			return;
		}
		if (cnt == N) {
			answer++;
		} else {
			sol(cnt + 1, left_sum + perm[cnt], right_sum);
			sol(cnt + 1, left_sum, right_sum + perm[cnt]);
		}
	}

	static void p_sol(int cnt, int flag) {
		if (cnt == N) {
			sol(0, 0, 0);
		} else {
			for (int i = 0; i < N; i++) {
				if ((flag & (1 << i)) == 0) {
					perm[cnt] = arr[i];
					p_sol(cnt + 1, flag | 1 << i);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			perm = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			answer = 0;
			p_sol(0, 0);

			System.out.println("#" + t + " " + answer);
		}

	}
}

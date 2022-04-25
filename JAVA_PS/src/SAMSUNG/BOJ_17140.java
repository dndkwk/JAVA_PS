package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_17140 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int r, c, k, N, M;
	static int[][] board = new int[100][100];

	static class pair {
		int val;
		int cnt;

		public pair(int val, int cnt) {
			super();
			this.val = val;
			this.cnt = cnt;
		}
	}

	static void row() {
		int n = N;
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			ArrayList<pair> val_cnt = new ArrayList<>();
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					continue;
				}
				arr.add(board[i][j]);
			}
			Collections.sort(arr);
			for (int j = 0; j < arr.size(); j++) {
				int pivot = j;
				while (pivot + 1 < arr.size() && arr.get(j) == arr.get(pivot + 1)) {
					pivot++;
				}
				val_cnt.add(new pair(arr.get(pivot), pivot - j + 1));
				j=pivot;
			}
			
			
			
			int last = 0;
			Collections.sort(val_cnt, (p1, p2) -> {
				if (p1.cnt != p2.cnt) {
					return p1.cnt - p2.cnt;
				} else {
					return p1.val - p2.val;
				}
			});
			for (int j = 0; j < val_cnt.size(); j++) {
				pair cur = val_cnt.get(j);
				board[i][last] = cur.val;
				last++;
				board[i][last] = cur.cnt;
				last++;
				if (last >= 100) {
					break;
				}
			}
			for(int j=last;j<100;j++) {
				board[i][j]=0;
			}
			M = Math.max(last, M);
		}
	}

	static void col() {
		int m = M;
		for (int i = 0; i < m; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			ArrayList<pair> val_cnt = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				if (board[j][i] == 0) {
					continue;
				}
				arr.add(board[j][i]);
			}
			Collections.sort(arr);
			for (int j = 0; j < arr.size(); j++) {
				int pivot = j;
				while (pivot + 1 < arr.size() && arr.get(j) == arr.get(pivot + 1)) {
					pivot++;
				}
				val_cnt.add(new pair(arr.get(pivot), pivot - j + 1));
				j=pivot;
			}
			Collections.sort(val_cnt, (p1, p2) -> {
				if (p1.cnt != p2.cnt) {
					return p1.cnt - p2.cnt;
				} else {
					return p1.val - p2.val;
				}
			});
			int last = 0;
			for (int j = 0; j < val_cnt.size(); j++) {
				pair cur = val_cnt.get(j);
				board[last][i] = cur.val;
				last++;
				board[last][i] = cur.cnt;
				last++;
				if (last >= 100) {
					break;
				}
			}
			for(int j=last;j<100;j++) {
				board[j][i]=0;
			}
			N = Math.max(last, N);
		}
	}

	static void show() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		r = stoi(st.nextToken()) - 1;
		c = stoi(st.nextToken()) - 1;
		k = stoi(st.nextToken());
		N = 3;
		M = 3;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				board[i][j] = stoi(st.nextToken());
			}
		}
		int t = 0;
		int ans = -1;
		while (t <= 100) {
//			show();
			if (board[r][c] == k) {
				ans = t;
				break;
			}
			if (N >= M) {
				row();
			} else {
				col();
			}
			t++;
			
		}

		System.out.println(ans);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

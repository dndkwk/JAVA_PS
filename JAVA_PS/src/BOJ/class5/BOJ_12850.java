package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_12850 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static long D;
	static int MOD = 1000000007;
	static long[][] board;

	static long[][] calc(long[][] a, long[][] b) {
		long[][] temp = new long[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					temp[i][j] = (temp[i][j] + a[i][k] * b[k][j]) % MOD;
				}
			}
		}
		return temp;
	}

	static long[][] sol(long num) {
		if (num == 1) {
			return board;
		}

		if (num % 2 == 1) {
			long[][] temp = sol(num / 2);
			return calc(calc(temp, temp), board);
		} else {
			long[][] temp = sol(num / 2);
			return calc(temp, temp);
		}

	}

	public static void main(String[] args) throws Exception {
		D = Long.parseLong(br.readLine());
		board = new long[][] { { 0, 1, 0, 0, 1, 0, 0, 0 }, { 1, 0, 1, 0, 1, 0, 0, 0 },
				{ 0, 1, 0, 1, 1, 0, 1, 0 }, { 0, 0, 1, 0, 0, 1, 1, 0 }, { 1, 1, 1, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0, 1, 1, 0 } };
		long[][] answer=sol(D);

		System.out.println(answer[0][0]);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

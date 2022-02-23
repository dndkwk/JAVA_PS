package SWEA;
import java.io.*;
import java.util.*;

public class Solution_6808 {

	static int T;
	static int[] A, B;
	static int[] result;
	static boolean[] check;
	static int cnt;

	static void sol(int num) {
		if (num == 9) {
			int AAA = 0;
			int BBB = 0;
			for (int i = 0; i < 9; i++) {
				if (A[i] > result[i]) {
					AAA += (A[i] + result[i]);
				} else {
					BBB += (A[i] + result[i]);
				}
			}
			if (AAA > BBB)
				cnt++;
		} else {
			for (int i = 0; i < 9; i++) {
				if (!check[i]) {
					result[num] = B[i];
					check[i] = true;
					sol(num + 1);
					check[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			boolean[] temp = new boolean[19];
			check = new boolean[9];
			A = new int[9];
			B = new int[9];
			result = new int[9];
			cnt = 0;

			for (int i = 0; i < 9; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				temp[A[i]] = true;
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!temp[i]) {
					B[idx] = i;
					idx++;
				}
			}

			sol(0);
			System.out.println("#" + t + " " + cnt + " " + (362880 - cnt));
		}

	}
}

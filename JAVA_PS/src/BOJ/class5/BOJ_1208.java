package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_1208 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N, S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		S = stoi(st.nextToken());

		int aa = N / 2;
		int bb = N - aa;

		int[] A = new int[20];
		int[] B = new int[20];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < aa; i++) {
			A[i] = stoi(st.nextToken());
		}

		for (int i = 0; i < bb; i++) {
			B[i] = stoi(st.nextToken());
		}
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		
		for (int i = 0; i < (1 << aa); i++) {
			int sum = 0;
			for (int k = 0; k < aa; k++) {
				if ((i & (1 << k)) != 0) {
					sum += A[k];
				}
			}
			a.add(sum);
		}

		for (int i = 0; i < (1 << bb); i++) {
			int sum = 0;
			for (int k = 0; k < bb; k++) {
				if ((i & (1 << k)) != 0) {
					sum += B[k];
				}
			}
			b.add(sum);
		}

		Collections.sort(a);
		Collections.sort(b);

		int left = 0;
		int right = b.size() - 1;
		long ans = 0;
		while (left < a.size() && right >= 0) {
			int lv = a.get(left);
			int rv = b.get(right);

			if (lv + rv == S) {
				long lc = 0;
				while (left < a.size() && a.get(left) == lv) {
					lc++;
					left++;
				}
				long rc = 0;
				while (right >= 0 && b.get(right) == rv) {
					rc++;
					right--;
				}

				ans += lc * rc;
			}

			if (lv + rv > S) {
				right--;
			}
			if (lv + rv < S) {
				left++;
			}

		}

		if (S == 0)
			ans--;
		System.out.println(ans);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

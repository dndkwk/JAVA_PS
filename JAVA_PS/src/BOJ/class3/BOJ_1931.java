package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_1931 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정

	static int N;

	static class pair {
		int start;
		int end;

		public pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		ArrayList<pair> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(arr, (pair p1, pair p2) -> {
			if (p1.end == p2.end) {
				return p1.start - p2.start;
			} else {
				return p1.end - p2.end;
			}

		});

		int cnt = 0;
		int last = 0;

		for (pair p : arr) {
			if (last <= p.start) {
				last = p.end;
				cnt++;
			}
		}

		System.out.println(cnt);

		return;
	}

}

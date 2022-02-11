package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_1074 {

	static int N, r, c;
	static int cnt = 0;

	static void sol(int y, int x, int m) {
		if (r == y && c == x) {
			System.out.println(cnt);
			return;
		}
		if (r < y + m && r >= y && c >= x && c < x + m) {
			sol(y, x, m / 2);
			sol(y, x + m / 2, m / 2);
			sol(y + m / 2, x, m / 2);
			sol(y + m / 2, x + m / 2, m / 2);

		} else {
			cnt += m * m;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int m = (int) Math.pow(2, N);
		sol(0, 0, m);

	}

}

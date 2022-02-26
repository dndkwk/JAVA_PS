package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_2961 {

	static int N;
	static int[] v1;
	static int[] v2;

	static int sol(int num) {
		int temp = 0;
		int multi = 1;
		int sum = 0;

		for (int i = 0; (1 << i) <= num; i++) {
			if ((num & (1 << i)) != 0) {
				multi *= v1[i];
				sum += v2[i];
			}
		}

		temp = Math.abs(multi - sum);

		return temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int result = Integer.MAX_VALUE;

		N = Integer.parseInt(br.readLine());

		v1 = new int[N];
		v2 = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			v1[i] = x;
			v2[i] = y;
		}

		for (int i = 1; i < (1 << N); i++) {
			result = Math.min(result, sol(i));
		}

		System.out.println(result);

	}

}

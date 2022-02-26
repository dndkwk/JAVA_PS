package BOJ;

import java.io.*;

public class BOJ_3040 {

	static int[] arr = new int[9];
	static int[] result = new int[7];

	static void sol(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += result[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(result[i]);

				}
			}
		} else {
			for (int i = start; i < 9; i++) {
				result[cnt] = arr[i];
				sol(cnt + 1, i + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		sol(0, 0);

	}

}

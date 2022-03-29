package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_15654 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N, M;
	static int[] result, arr;

	public static void sol(int cnt, int flag) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println("");
		} else {
			for (int i = 0; i < N; i++) {
				if((flag & (1<<i)) == 0) {
					result[cnt] = arr[i];
					sol(cnt + 1, flag | (1<<i) );
				}

			}
		}

	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] =Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		sol(0, 0);

	}
}

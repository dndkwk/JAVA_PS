package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_15666 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N, M,L;
	static int[] result, arr;

	public static void sol(int cnt, int idx) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println("");
		} else {
			for (int i = idx; i < arr.length; i++) {
				result[cnt] = arr[i];
				sol(cnt + 1, i);

			}
		}

	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];

		Set<Integer> set=new HashSet<>();		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		arr = new int[set.size()];
		int idx=0;
		for(int temp:set) {
			arr[idx]=temp;
			idx++;
		}
		Arrays.sort(arr);
		
		sol(0, 0);

	}
}

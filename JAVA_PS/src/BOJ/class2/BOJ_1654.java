package BOJ.class2;

import java.io.*;
import java.util.*;

public class BOJ_1654 {

	static int[] arr;

	static int solution(long mid) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			cnt += arr[i] / mid;
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		long start = 1, end = 0;
		long result = 0;
		arr = new int[K];

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, arr[i]);
		}
		while (start <= end) {
			long mid = (start + end) / 2;

			if (solution(mid) >= N) {
				result = Math.max(mid, result);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		System.out.println(result);

	}

}

package BOJ.class5;
import java.util.*;
import java.io.*;

public class BOJ_12015 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M;
	static int[] board;
	static int[] result;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		board = new int[N];
		List<Integer> result = new ArrayList<Integer>();
		result.add(0);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			board[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			int val = board[i];
			if (val > result.get(result.size() - 1)) {
				result.add(val);
			} else {
				int left = 0;
				int right = result.size() - 1;
				while (left < right) {
					int mid = (left + right) / 2;
					if (result.get(mid) >= val) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
				result.set(right, val);
			}

		}
		System.out.println(result.size()-1);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}


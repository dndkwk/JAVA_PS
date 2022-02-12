package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_1620 {

	static int N, M;

	static boolean isnum(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		HashMap<String, Integer> str = new HashMap<>();
		HashMap<Integer, String> num = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			String temp = br.readLine();
			str.put(temp, i);
			num.put(i, temp);
		}

		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			if (isnum(temp)) {
				sb.append(num.get(Integer.parseInt(temp)) + "\n");
			} else {
				sb.append(str.get(temp) + "\n");
			}

		}

		System.out.println(sb.toString());

	}

}

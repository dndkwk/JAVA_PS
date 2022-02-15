package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_7662 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정

	static int T, k;

	public static void main(String[] args) throws Exception {

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				String temp = st.nextToken();
				int n = Integer.parseInt(st.nextToken());

				if (temp.equals("I")) {
					map.put(n, map.getOrDefault(n, 0) + 1);
				} else {
					if (map.isEmpty()) {
						continue;
					}

					if (n == 1) {
						int num = map.lastKey();
						if (map.put(num, map.get(num) - 1) == 1) {
							map.remove(num);
						}
					} else {
						int num = map.firstKey();
						if (map.put(num, map.get(num) - 1) == 1) {
							map.remove(num);
						}
					}

				}
			}
			if(map.isEmpty()) {
				System.out.println("EMPTY");
			}else {
				System.out.println(map.lastKey()+" "+map.firstKey());
			}
			
		}

		return;
	}

}

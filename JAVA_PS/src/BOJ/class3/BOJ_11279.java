package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_11279 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		sb = new StringBuilder();

		for (int t = 0; t < N; t++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp == 0) {
				if (pq.isEmpty()) {
					sb.append(0+"\n");
				} else {
					sb.append(pq.poll() + "\n");
				}
			} else {
				pq.add(temp);
			}
		}
		System.out.println(sb);
		
		return;
	}

}

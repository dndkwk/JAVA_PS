package BOJ.class2;

import java.io.*;
import java.util.*;

public class BOJ_11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		int cnt = 0;

		sb.append("<");

		while (q.size() != 1) {
			cnt++;
			int temp = q.poll();
			if (cnt == K) {
				sb.append(temp + ", ");
			} else {
				q.add(temp);
			}

			cnt %= K;
		}
		sb.append(q.poll() + ">");
		System.out.println(sb);

	}

}

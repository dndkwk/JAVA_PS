package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_1697 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static boolean[] visited = new boolean[100001];

	static class pair {
		int n;
		int cnt;

		public pair(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Queue<pair> q = new LinkedList<pair>();
		q.add(new pair(N, 0));
		visited[N] = true;

		while (!q.isEmpty()) {
			int nn = q.peek().n;
			int count = q.peek().cnt;
			q.poll();

			if (nn == K) {
				sb.append(count);
				break;
			}

			if (nn + 1 < 100001 && visited[nn+1] == false) {
				q.add(new pair(nn+1,count+1));
				visited[nn+1]=true;
			}

			if (nn - 1 >=0 && visited[nn-1] == false) {
				q.add(new pair(nn-1,count+1));
				visited[nn-1]=true;
			}

			if (nn *2 < 100001 && visited[nn*2] == false) {
				q.add(new pair(nn*2,count+1));
				visited[nn*2]=true;
			}

		}
		
		System.out.println(sb);
		
		return;
	}

}

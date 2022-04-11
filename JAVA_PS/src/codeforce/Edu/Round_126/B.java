package codeforce.Edu.Round_126;

import java.io.*;
import java.util.*;

public class B {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int[] arr = new int[32769];
	static int MOD = 32768;

	static void sol() {

		Queue<Integer> q = new LinkedList<>();
		arr[0] = 0;
		q.add(0);
		while (!q.isEmpty()) {
			int cur = q.poll();
			int p1 = (cur + 32768 - 1) % 32768;
			if(arr[p1]==-1) {
				arr[p1]=arr[cur]+1;
				q.add(p1);
			}
			if(cur%2==0) {
				int p2=cur/2;
				if(arr[p2]==-1) {
					arr[p2]=arr[cur]+1;
					q.add(p2);
				}
				p2+=32768/2;
				if(arr[p2]==-1) {
					arr[p2]=arr[cur]+1;
					q.add(p2);
				}
			}
			
		}

	}

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		Arrays.fill(arr, -1);
		sol();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sb.append(arr[Integer.parseInt(st.nextToken())] + " ");
		}

		System.out.println(sb);
	}

}

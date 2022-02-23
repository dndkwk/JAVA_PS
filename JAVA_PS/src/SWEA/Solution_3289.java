package SWEA;
import java.io.*;
import java.util.*;

public class Solution_3289 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/*  */

	static int[] arr;

	static int find(int x) {
		if (x == arr[x]) {
			return x;
		}

		return arr[x] = find(arr[x]);
	}

	static void union(int y, int x) {
		y=find(y);
		x=find(x);
		
		arr[y]=x;
		
	}

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				arr[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int temp = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (temp == 0) {
					union(a, b);
				} else {
					if (find(a) == find(b)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}

			}

			System.out.println("#" + t + " " + sb);
			sb.setLength(0);
		}

	}
}

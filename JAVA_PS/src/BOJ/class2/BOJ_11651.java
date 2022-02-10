package BOJ.class2;

import java.io.*;
import java.util.*;

public class BOJ_11651 {

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		ArrayList<Pair> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(arr, (Pair p1, Pair p2) -> {
			if (p1.y == p2.y) {
				return p1.x - p2.x;
			}
			return p1.y - p2.y;
		});
		
		for(int i=0;i<N;i++) {
			System.out.println(arr.get(i).x+" "+arr.get(i).y);
		}

	}

}

package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1708 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static pair root = new pair(Long.MAX_VALUE, Long.MAX_VALUE);

	static class pair {
		long x;
		long y;

		public pair(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int ccw(pair a, pair b, pair c) {
		long result = (a.x * b.y + b.x * c.y + c.x * a.y) - (b.x * a.y + c.x * b.y + a.x * c.y);
		if (result > 0)
			return 1;
		if (result < 0)
			return -1;
		return 0;
	}

	static long dist(pair a, pair b) {
		return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
	}

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		ArrayList<pair> board = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			board.add(new pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
		}

		for (int i = 0; i < board.size(); i++) {
			if (board.get(i).y < root.y) {
				root = board.get(i);
			} else if (board.get(i).y == root.y) {
				if (board.get(i).x < root.x) {
					root = board.get(i);
				}
			}
		}

		Collections.sort(board, (p1, p2) -> {
			int result = ccw(root, p1, p2);
			if (result > 0) {
				return -1;
			} else if (result < 0) {
				return 1;
			} else if (result == 0) {
				long dist1 = dist(root, p1);
				long dist2 = dist(root, p2);
				if (dist1 > dist2) {
					return 1;
				}
			}
			return -1;
		});

		Stack<pair> stack = new Stack<>();
		stack.add(root);

		for (int i = 1; i < board.size(); i++) {
			while (stack.size() > 1
					&& ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), board.get(i)) <= 0) {
				stack.pop();
			}
			stack.add(board.get(i));
		}
		System.out.println(stack.size());

	}

}

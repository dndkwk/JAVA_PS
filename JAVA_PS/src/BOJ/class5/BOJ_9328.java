package BOJ.class5;
import java.util.*;
import java.io.*;

public class BOJ_9328 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int T;
	static int H, W;
	static char[][] board = new char[102][102];
	static boolean[][] vis = new boolean[102][102];
	static boolean[] key = new boolean[26];
	static int document;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static void sol(int y, int x) {
		Queue<pair> q = new LinkedList<pair>();
		q.add(new pair(y, x));

		while (!q.isEmpty()) {
			pair cur = q.poll();

			if (cur.y < 0 || cur.y > H + 1 || cur.x < 0 || cur.x > W + 1) {
				continue;
			}

			if (vis[cur.y][cur.x] || board[cur.y][cur.x] == '*'
					|| ('A' <= board[cur.y][cur.x] && board[cur.y][cur.x] <= 'Z')) {
				continue;
			}
			vis[cur.y][cur.x]=true;

			if (board[cur.y][cur.x] == '$') {
				document++;
				board[cur.y][cur.x] = '.';
			}

			if ('a' <= board[cur.y][cur.x] && board[cur.y][cur.x] <= 'z') {
				char door = Character.toUpperCase(board[cur.y][cur.x]);
				board[cur.y][cur.x] = '.';
				if (key[door - 'A'] == false) {
					key[door - 'A'] = true;
					for (int i = 1; i <= H; i++) {
						for (int j = 1; j <= W; j++) {
							if (board[i][j] == door) {
								board[i][j] = '.';
							}
						}
					}
				}
				for (int i = 0; i < vis.length; i++) {
					Arrays.fill(vis[i], false);
				}
				while (!q.isEmpty()) {
					q.poll();
				}
				q.add(new pair(cur.y, cur.x));
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				q.add(new pair(ny, nx));
			}

		}

	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			H = stoi(st.nextToken());
			W = stoi(st.nextToken());

			Arrays.fill(key, false);
			for (int i = 0; i < vis.length; i++) {
				Arrays.fill(vis[i], false);
			}
			for (int i = 1; i <= H; i++) {
				String temp = br.readLine();
				for (int j = 1; j <= W; j++) {
					board[i][j] = temp.charAt(j - 1);
				}
			}
			for (int j = 0; j <= W + 1; j++) {
				board[0][j] = '.';
				board[H + 1][j] = '.';
			}
			for (int i = 0; i <= H + 1; i++) {
				board[i][0] = '.';
				board[i][W + 1] = '.';
			}

			String alpha = br.readLine();

			for (int k = 0; !alpha.equals("0") && k < alpha.length(); k++) {
				key[alpha.charAt(k) - 'a'] = true;
				for (int i = 1; i <= H; i++) {
					for (int j = 1; j <= W; j++) {
						if (board[i][j] == Character.toUpperCase(alpha.charAt(k))) {
							board[i][j] = '.';
						}
					}
				}
			}
			

			document = 0;
			sol(0, 0);
			sb.append(document + "\n");

		}
		System.out.println(sb);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

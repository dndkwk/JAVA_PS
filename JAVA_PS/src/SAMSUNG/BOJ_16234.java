package SAMSUNG;
import java.util.*;
import java.io.*;

public class BOJ_16234 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, L, R;
	static int[][] board;
	static int[][] temp;
	static boolean[][] vis;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static void bfs(int y, int x) {
		Queue<pair> q = new LinkedList<pair>();
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<pair> pos = new ArrayList<>();
		vis[y][x] = true;

		q.add(new pair(y, x));
		arr.add(board[y][x]);
		pos.add(new pair(y, x));

		while (!q.isEmpty()) {
			pair cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
					continue;
				}

				if (vis[ny][nx] == false && L <= Math.abs(board[cur.y][cur.x] - board[ny][nx])
						&& Math.abs(board[cur.y][cur.x] - board[ny][nx]) <= R) {
					q.add(new pair(ny, nx));
					vis[ny][nx] = true;
					pos.add(new pair(ny, nx));
					arr.add(board[ny][nx]);
				}
			}
		}

		int avg = 0;
		for (int i : arr) {
			avg += i;
		}
		avg /= arr.size();
		for (pair cur : pos) {
			temp[cur.y][cur.x] = avg;
		}

	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		L = stoi(st.nextToken());
		R = stoi(st.nextToken());

		board = new int[N][N];
		temp = new int[N][N];
		vis = new boolean[N][N];
		boolean check = true;
		int cnt=0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = stoi(st.nextToken());
			}
		}

		// 여기부터
		while (true) {

			for (int i = 0; i < N; i++) {
				Arrays.fill(vis[i], false);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (vis[i][j]) {
						continue;
					}
					bfs(i, j);
				}
			}
			check = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] != temp[i][j]) {
						board[i][j] = temp[i][j];
						check = true;
					}
				}
			}
			if (!check) {
				break;
			}
			cnt++;
		}
		
		System.out.println(cnt);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

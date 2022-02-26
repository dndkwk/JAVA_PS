package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_2667 {

	static int N;
	static int[][] board = new int[25][25];
	static boolean[][] visited = new boolean[25][25];
	static int cnt;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Pair {
		int x;
		int y;

		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static void sol(int n, int m) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(n, m));
		visited[n][m] = true;

		while (!q.isEmpty()) {
			int y = q.peek().y;
			int x = q.peek().x;
			q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				if (board[ny][nx] == 1 && visited[ny][nx] == false) {
					q.add(new Pair(ny, nx));
					visited[ny][nx] = true;
					cnt++;
				}
			}

		}

	}

	static void sol2(int n, int m) {
		Stack<Pair> s = new Stack<>();
		s.add(new Pair(n, m));
		visited[n][m] = true;

		while (!s.empty()) {
			int y = s.peek().y;
			int x = s.peek().x;
			s.pop();
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				if (board[ny][nx] == 1 && visited[ny][nx] == false) {
					s.add(new Pair(ny, nx));
					visited[ny][nx] = true;
					cnt++;
				}
			}
			
			
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// tringTokenizer st=null;
		N = Integer.parseInt(br.readLine());

		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				board[i][j] = c[j] - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1 && visited[i][j] == false) {
					cnt = 1;
					sol2(i, j);
					arr.add(cnt);
				}
			}
		}
		Collections.sort(arr);
		System.out.println(arr.size());
		for (int n : arr) {
			System.out.println(n);
		}

	}

}

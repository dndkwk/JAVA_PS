package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_10026 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/*  */

	static int N;
	static char[][] board;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class pair {
		int y;
		int x;
		char color;

		public pair(int y, int x,char color) {
			super();
			this.y = y;
			this.x = x;
			this.color=color;
		}

	}

	static void sol1(int y, int x,char color) {
		Queue<pair> q = new LinkedList<pair>();
		q.add(new pair(y, x,color));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			pair cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				
				if(visited[ny][nx]==false && board[ny][nx]==cur.color) {
					q.add(new pair(ny,nx,cur.color));
					visited[ny][nx]=true;
				}

			}

		}

	}

	static void sol2(int y, int x,char color) {
		Queue<pair> q = new LinkedList<pair>();
		q.add(new pair(y, x,color));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			pair cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				
				if(cur.color=='B') {
					if(visited[ny][nx]==false && board[ny][nx]==cur.color) {
						q.add(new pair(ny,nx,cur.color));
						visited[ny][nx]=true;
					}
				}else {
					if(visited[ny][nx]==false && board[ny][nx]!='B') {
						q.add(new pair(ny,nx,cur.color));
						visited[ny][nx]=true;
					}
				}
				

			}

		}
		
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				board[i][j] = temp[j];
			}
		}

		visited = new boolean[N][N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					cnt++;
					sol1(i, j,board[i][j]);
				}
			}
		}

		int A = cnt;

		visited = new boolean[N][N];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					cnt++;
					sol2(i, j,board[i][j]);
				}
			}
		}
		int B = cnt;

		System.out.println(A+" "+B);
	}
}

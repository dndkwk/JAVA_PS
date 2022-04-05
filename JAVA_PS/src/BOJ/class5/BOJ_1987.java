package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_1987 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int R, C;
	static char[][] board;
	static boolean[] visited;
	static int answer;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static void sol(int cnt, int y, int x) {
		if (visited[board[y][x] - 'A']) {
			answer = Math.max(cnt, answer);
			return;
		}
		visited[board[y][x] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
				continue;
			}
			sol(cnt + 1, ny, nx);
		}
		visited[board[y][x] - 'A'] = false;

	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		board = new char[R][C];
		visited = new boolean[30];

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < temp.length(); j++) {
				board[i][j] = temp.charAt(j);
			}
		}

		sol(0, 0, 0);
		System.out.println(answer);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}


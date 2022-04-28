package SAMSUNG;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class BOJ_19236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[][] board = new int[4][4];
	static pair[] fish = new pair[17];
	static boolean[] vis = new boolean[17];
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int score = 0;

	static class pair {
		int y;
		int x;
		int dir;

		public pair(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}

	static void move() {
		// 물고기 이동
		for (int i = 1; i < 17; i++) {
			if (vis[i]) {// 먹힌 애는 스킵
				continue;
			}
			int y = fish[i].y;
			int x = fish[i].x;
			int dir = fish[i].dir;

			for (int j = dir; j < dir + 8; j++) {
				int ny = y + dy[j % 8];
				int nx = x + dx[j % 8];
				// 못가는 조건들
				if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4) {
					continue;
				}
				// 상어칸 X
				if (board[ny][nx] == -1) {
					continue;
				}

				fish[i].dir = j % 8;
				// 빈칸
				if (board[ny][nx] == 0) {
					board[y][x] = 0;
					board[ny][nx] = i;

					fish[i].y = ny;
					fish[i].x = nx;
				} else {
					// 위치 바꾸기
					int nxt = board[ny][nx];
					fish[nxt].y = y;
					fish[nxt].x = x;
					board[y][x] = nxt;

					fish[i].y = ny;
					fish[i].x = nx;
					board[ny][nx] = i;
				}				
				break;
			}

		}
	}

	static void sol(int sy, int sx, int sd, int sum) {
		score = Math.max(sum, score);

		int[][] dump_board = new int[4][4];
		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				dump_board[a][b] = board[a][b];
			}
		}
		pair[] dump_fish = new pair[17];
		for (int n = 1; n < 17; n++) {
			dump_fish[n] = new pair(fish[n].y, fish[n].x, fish[n].dir);
		}

		move();

		for (int i = 1; i < 4; i++) {
			int ny = sy + dy[sd] * i;
			int nx = sx + dx[sd] * i;
			if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4) {
				continue;
			}

			if (board[ny][nx] != 0) {
				// 범위를 벗어나지않고 갈 수 있는 칸
				// 백트래킹
				int idx = board[ny][nx];
				int nd = fish[idx].dir;

				board[sy][sx] = 0;
				board[ny][nx] = -1;
				vis[idx] = true;

				sol(ny, nx, nd, sum + idx);

				// 복구
				vis[idx] = false;
				board[sy][sx] = -1;
				board[ny][nx] = idx;
			}
		}

		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				board[a][b] = dump_board[a][b];
			}
		}
		for (int n = 1; n < 17; n++) {
			fish[n] = new pair(dump_fish[n].y, dump_fish[n].x, dump_fish[n].dir);
		}
	}

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = stoi(st.nextToken());
				int dir = stoi(st.nextToken()) - 1;
				board[i][j] = num;
				fish[num] = new pair(i, j, dir);
			}
		}

		// 0 0 칸에 들어감
		int sx = 0, sy = 0;
		int sd = fish[board[sy][sx]].dir;
		int sum = board[sy][sx];
		vis[sum] = true;
		board[sy][sx] = -1;
		sol(sy, sx, sd, sum);

		System.out.println(score);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}


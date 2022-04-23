package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_14499 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M, x, y, K;
	static int[] dice = new int[7];
	static int[] value = new int[7];
	static int[] dy = {0, 0, 0, -1, 1 };
	static int[] dx = {0, 1, -1, 0, 0 };
	static int[][] board;

	static int up(int idx) {
		switch (idx) {
		case 1:
			return 6;
		case 2:
			return 5;
		case 3:
			return 4;
		case 4:
			return 3;
		case 5:
			return 2;
		case 6:
			return 1;
		}
		return -1;
	}

	static int move(int idx, int dir) {
		int[] temp = new int[7];
		if (dir == 1) {
			temp[1] = dice[3];
			temp[2] = dice[2];
			temp[3] = dice[6];
			temp[4] = dice[1];
			temp[5] = dice[5];
			temp[6] = dice[4];
		} else if (dir == 2) {
			temp[1] = dice[4];
			temp[2] = dice[2];
			temp[3] = dice[1];
			temp[4] = dice[6];
			temp[5] = dice[5];
			temp[6] = dice[3];
		} else if (dir == 3) {
			temp[1] = dice[2];
			temp[2] = dice[6];
			temp[3] = dice[3];
			temp[4] = dice[4];
			temp[5] = dice[1];
			temp[6] = dice[5];
		} else if (dir == 4) {
			temp[1] = dice[5];
			temp[2] = dice[1];
			temp[3] = dice[3];
			temp[4] = dice[4];
			temp[5] = dice[6];
			temp[6] = dice[2];
		}
		for (int i = 0; i < 7; i++) {
			dice[i] = temp[i];
		}
		return dice[1];
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		y = stoi(st.nextToken());
		x = stoi(st.nextToken());
		K = stoi(st.nextToken());

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = stoi(st.nextToken());
			}
		}

		int[] dirs = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			dirs[i] = stoi(st.nextToken());
		}

		for (int i = 0; i < 7; i++) {
			dice[i] = i;
		}

		int idx = 1;
		for (int t = 0; t < K; t++) {
			int nx=x+dx[dirs[t]];
			int ny=y+dy[dirs[t]];
			if(nx < 0 || nx >= M || ny<0||ny>=N) {
				continue;
			}
			y=ny;
			x=nx;
			idx = move(idx, dirs[t]);
			if(board[y][x]==0) {
				board[y][x]=value[idx];
			}else {
				value[idx]=board[y][x];
				board[y][x]=0;
			}
			sb.append(value[up(idx)] + "\n");
		}
		System.out.println(sb);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

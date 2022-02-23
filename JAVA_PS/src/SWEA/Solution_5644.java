package SWEA;

import java.io.*;
import java.util.*;

public class Solution_5644 {

	static int M, T, A, result;
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };
	static int[][] board = new int[10][10];
	static int[][][] BC;
	static int[] dA, dB;
	static pair a, b;

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static void sol() {
		ArrayList<Integer> AAA = new ArrayList<>();
		ArrayList<Integer> BBB = new ArrayList<>();

		for (int i = 0; i < A; i++) {
			if (BC[a.y][a.x][i] != 0) {
				AAA.add(i);
			}
			if (BC[b.y][b.x][i] != 0) {
				BBB.add(i);
			}
		}

		int max = 0, ap = 0, bp = 0;
		int Asize = AAA.size(), Bsize = BBB.size();

		if (Asize == 0 && Bsize == 0) {
			return;
		} else if (Asize == 0) {
			for (int idx : BBB) {
				int sum = BC[b.y][b.x][idx];
				bp = Math.max(bp, sum);
			}
		} else if (Bsize == 0) {
			for (int idx : AAA) {
				int sum = BC[a.y][a.x][idx];
				ap = Math.max(ap, sum);
			}
		} else {
			for (int i : AAA) {
				for (int j : BBB) {
					int sum = 0;
					if (i == j) {
						sum = BC[b.y][b.x][i];
						if (sum > max) {
							ap = sum / 2;
							bp = sum / 2;
							max = sum;
						}
					} else {
						sum = BC[b.y][b.x][j] + BC[a.y][a.x][i];
						if (sum > max) {
							ap = BC[a.y][a.x][i];
							bp = BC[b.y][b.x][j];
							max = sum;
						}
					}
				}
			}
		}
		
		result+=(ap+bp);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			dA = new int[M];
			dB = new int[M];
			BC = new int[11][11][A];
			a = new pair(0, 0);
			b = new pair(9, 9);
			result=0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				dA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				dB[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken())-1;
				int Y = Integer.parseInt(st.nextToken())-1;
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < 10; j++) {
					for (int k = 0; k < 10; k++) {
						if ((Math.abs(j - Y) + Math.abs(k - X)) <= C) {
							BC[j][k][i] = P;
						}
					}
				}
			}

			sol();
			for (int step = 0; step < M; step++) {
				a.y += dy[dA[step]];
				a.x += dx[dA[step]];
				
				b.y += dy[dB[step]];
				b.x += dx[dB[step]];
				
				sol();
			}
			System.out.println("#"+t+" "+result);

		}

	}
}

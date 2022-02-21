package BOJ.IM;

import java.util.*;
import java.io.*;

public class BOJ_2116 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	static int sum;
	static int N;
	static int[][] dice;

	static void dfs(int floor, int bottom) {
		if (floor == N)
			return;

		int top = -1;
		switch (bottom) {
		case 0:
			top = 5;
			break;
		case 1:
			top = 3;
			break;
		case 2:
			top = 4;
			break;
		case 3:
			top = 1;
			break;
		case 4:
			top = 2;
			break;
		case 5:
			top = 0;
			break;
		}

		int max = -1;
		int next = -1;

		for (int i = 0; i < 6; i++) {
			if (floor < N - 1 && dice[floor + 1][i] == dice[floor][top]) {
				next = i;
			}
			if (i != bottom && i != top) {
				max = Math.max(max, dice[floor][i]);
			}
		}
		
		sum+=max;
		dfs(floor+1,next);
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = -1;
		for (int i = 0; i < 6; i++) {
			sum = 0;
			dfs(0, i);
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
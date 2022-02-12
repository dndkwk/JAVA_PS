package BOJ.IM;

import java.io.*;
import java.util.*;

public class BOJ_2578 {

	static int[][] board = new int[5][5];
	static boolean[][] visited = new boolean[5][5];

	static boolean sol(int n) {
		int cnt = 0;
		boolean flag = true;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == n) {
					visited[i][j] = true;
					break;
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			flag = true;
			for (int j = 0; j < 5; j++) {
				if (visited[i][j] == false) {
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt++;
			}

			flag = true;
			for (int j = 0; j < 5; j++) {
				if (visited[j][i] == false) {
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt++;
			}

		}

		flag = true;
		for (int i = 0; i < 5; i++) {
			if (visited[i][i] == false) {
				flag = false;
				break;
			}
		}

		if (flag) {
			cnt++;
		}

		flag = true;
		for (int i = 0; i < 5; i++) {
			if (visited[i][4 - i] == false) {
				flag = false;
				break;
			}
		}

		if (flag) {
			cnt++;
		}

		if (cnt >= 3) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int result=987654321;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				if(sol(Integer.parseInt(st.nextToken()))){
					result=Math.min(result, i*5+j+1);
					break;
				}
			}
		}
		
		System.out.println(result);

	}

}

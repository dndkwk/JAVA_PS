package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_14939 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int[] dx = { 0, 0, 0, 1, -1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		boolean[][] board = new boolean[10][10];
		boolean[][] board2 = new boolean[10][10];

		for (int i = 0; i < 10; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 10; j++) {
				if (temp.charAt(j) == 'O') {
					board[i][j] = true;
				} else {
					board[i][j] = false;
				}
			}
		}

		int ans = 987654231;
		for (int k = 0; k < 1024; k++) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					board2[i][j] = board[i][j];
				}
			}
			int cnt = 0;
			int bf = k;
			for (int i = 0; i < 10; i++) {
				if ((bf & (1 << i)) != 0) {
					cnt++;
					for (int t = 0; t < 5; t++) {
						int ny = 0 + dy[t];
						int nx = i + dx[t];
						if (ny < 0 || ny >= 10 || nx < 0 || nx >= 10) {
							continue;
						}
						board2[ny][nx] = !board2[ny][nx];
					}
				}
			}
			for (int i = 1; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (board2[i - 1][j]) {
						cnt++;
						for (int t = 0; t < 5; t++) {
							int ny = i + dy[t];
							int nx = j + dx[t];
							if (ny < 0 || ny >= 10 || nx < 0 || nx >= 10) {
								continue;
							}
							board2[ny][nx] = !board2[ny][nx];
						}
					}
				}
			}

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (board2[i][j]) {
						cnt = -1;
						break;
					}
				}
			}
			if (cnt != -1) {
				ans = Math.min(ans, cnt);
			}

		}

//		for(int i=0;i<10;i++) {
//			for(int j=0;j<10;j++) {
//				if(board[i][j]) {
//					System.out.print("1");
//				}else {
//					System.out.print("0");
//				}
//			}
//			System.out.println("");
//		}

		System.out.println(ans == 987654231 ? -1 : ans);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

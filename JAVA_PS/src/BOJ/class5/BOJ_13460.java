package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_13460 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N, M;
	static char[][] board;
	static char[][] temp;
	static int r_y = 0, r_x = 0;
	static int b_y = 0, b_x = 0;
	static int g_y,g_x;
	static int ans = 987564321;

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static boolean move0() {// 상
		if (r_y < b_y) {// R먼저 올리기
			temp[r_y][r_x] = '.';
			while (true) {
				if (r_y - 1 < 0) {
					break;
				}
				r_y--;
				if (temp[r_y][r_x] == 'O') {
					break;
				}
				if (temp[r_y][r_x] != '.') {
					r_y++;
					break;
				}

			}
			temp[r_y][r_x] = 'R';
			temp[g_y][g_x]='O';
			temp[b_y][b_x] = '.';
			while (true) {
				if (b_y - 1 < 0) {
					break;
				}
				b_y--;
				if (temp[b_y][b_x] == 'O') {
					break;
				}
				if (temp[b_y][b_x] != '.') {
					b_y++;
					break;
				}
			}
			temp[b_y][b_x] = 'B';
			temp[g_y][g_x]='O';
		} else {
			temp[b_y][b_x] = '.';
			while (true) {
				if (b_y - 1 < 0) {
					break;
				}
				b_y--;
				if (temp[b_y][b_x] == 'O') {
					break;
				}
				if (temp[b_y][b_x] != '.') {
					b_y++;
					break;
				}
			}
			temp[b_y][b_x] = 'B';
			temp[g_y][g_x]='O';
			temp[r_y][r_x] = '.';
			while (true) {
				if (r_y - 1 < 0) {
					break;
				}
				r_y--;
				if (temp[r_y][r_x] == 'O') {
					break;
				}
				if (temp[r_y][r_x] != '.') {
					r_y++;
					break;
				}
			}
			temp[r_y][r_x] = 'R';
			temp[g_y][g_x]='O';
		}

		return false;
	}

	static boolean move1() {// 하
		if (r_y > b_y) {// R먼저 내리기
			temp[r_y][r_x] = '.';
			while (true) {
				if (r_y + 1 >= N) {
					break;
				}
				r_y++;
				if (temp[r_y][r_x] == 'O') {
					break;
				}
				if (temp[r_y][r_x] != '.') {
					r_y--;
					break;
				}
			}
			temp[r_y][r_x] = 'R';
			temp[g_y][g_x]='O';
			temp[b_y][b_x] = '.';
			while (true) {
				if (b_y + 1 >= N) {
					break;
				}
				b_y++;
				if (temp[b_y][b_x] == 'O') {
					break;
				}
				if (temp[b_y][b_x] != '.') {
					b_y--;
					break;
				}
			}
			temp[b_y][b_x] = 'B';
			temp[g_y][g_x]='O';
		} else {
			temp[b_y][b_x] = '.';
			while (true) {
				if (b_y + 1 >= N) {
					break;
				}
				b_y++;
				if (temp[b_y][b_x] == 'O') {
					break;
				}
				if (temp[b_y][b_x] != '.') {
					b_y--;
					break;
				}
			}
			temp[b_y][b_x] = 'B';
			temp[g_y][g_x]='O';
			temp[r_y][r_x] = '.';
			while (true) {
				if (r_y + 1 >= N) {
					break;
				}
				r_y++;
				if (temp[r_y][r_x] == 'O') {
					break;
				}
				if (temp[r_y][r_x] != '.') {
					r_y--;
					break;
				}
			}
			temp[r_y][r_x] = 'R';
			temp[g_y][g_x]='O';
		}

		return false;
	}

	static boolean move2() {// 우
		if (r_x > b_x) {// R먼저 오른쪽
			temp[r_y][r_x] = '.';
			while (true) {
				if (r_x + 1 >= M) {
					break;
				}
				r_x++;
				if (temp[r_y][r_x] == 'O') {
					break;
				}
				if (temp[r_y][r_x] != '.') {
					r_x--;
					break;
				}
			}
			temp[r_y][r_x] = 'R';
			temp[g_y][g_x]='O';
			temp[b_y][b_x] = '.';
			while (true) {
				if (b_x + 1 >= M) {
					break;
				}
				b_x++;
				if (temp[b_y][b_x] == 'O') {
					break;
				}
				if (temp[b_y][b_x] != '.') {
					b_x--;
					break;
				}
			}
			temp[b_y][b_x] = 'B';
			temp[g_y][g_x]='O';
		} else {
			temp[b_y][b_x] = '.';
			while (true) {
				if (b_x + 1 >= M) {
					break;
				}
				b_x++;
				if (temp[b_y][b_x] == 'O') {
					break;
				}
				if (temp[b_y][b_x] != '.') {
					b_x--;
					break;
				}
			}
			temp[b_y][b_x] = 'B';
			temp[g_y][g_x]='O';
			temp[r_y][r_x] = '.';
			while (true) {
				if (r_x + 1 >= M) {
					break;
				}
				r_x++;
				if (temp[r_y][r_x] == 'O') {
					break;
				}
				if (temp[r_y][r_x] != '.') {
					r_x--;
					break;
				}
			}
			temp[r_y][r_x] = 'R';
			temp[g_y][g_x]='O';
		}

		return false;
	}

	static boolean move3() {// 좌
		if (r_x < b_x) {// R먼저 왼쪽
			temp[r_y][r_x] = '.';
			while (true) {
				if (r_x - 1 < 0) {
					break;
				}
				r_x--;
				if (temp[r_y][r_x] == 'O') {
					break;
				}
				if (temp[r_y][r_x] != '.') {
					r_x++;
					break;
				}
			}
			temp[r_y][r_x] = 'R';
			temp[g_y][g_x]='O';
			temp[b_y][b_x] = '.';
			while (true) {
				if (b_x - 1 < 0) {
					break;
				}
				b_x--;
				if (temp[b_y][b_x] == 'O') {
					break;
				}
				if (temp[b_y][b_x] != '.') {
					b_x++;
					break;
				}
			}
			temp[b_y][b_x] = 'B';
			temp[g_y][g_x]='O';
		} else {
			temp[b_y][b_x] = '.';
			while (true) {
				if (b_x - 1 < 0) {
					break;
				}
				b_x--;
				if (temp[b_y][b_x] == 'O') {
					break;
				}
				if (temp[b_y][b_x] != '.') {
					b_x++;
					break;
				}
			}
			temp[b_y][b_x] = 'B';
			temp[g_y][g_x]='O';
			temp[r_y][r_x] = '.';
			while (true) {
				if (r_x - 1 < 0) {
					break;
				}
				r_x--;
				if (temp[r_y][r_x] == 'O') {
					break;
				}
				if (temp[r_y][r_x] != '.') {
					r_x++;
					break;
				}
			}
			temp[r_y][r_x] = 'R';
			temp[g_y][g_x]='O';
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		board = new char[N][M];
		temp = new char[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);
			}
		}

		for (int k = 0; k < (int) Math.pow(4, 10); k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = board[i][j];
					if (temp[i][j] == 'R') {
						r_y = i;
						r_x = j;
					}
					if (temp[i][j] == 'B') {
						b_y = i;
						b_x = j;
					}
					if (temp[i][j] == 'O') {
						g_y = i;
						g_x = j;
					}
				}
			}
//			move3();
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(temp[i][j] + "");
//				}
//				System.out.println("");
//			}
//			
//			
//			if(true)break;

			int bf = k;
			for (int i = 0; i < 10; i++) {
				int t = bf % 4;
				bf /= 4;
				if (t == 0) {
					move0();
					if(board[b_y][b_x]=='O') {
						break;
					}
					if(board[r_y][r_x]=='O') {
						ans = Math.min(ans, i + 1);
						break;
					}
					
				} else if (t == 1) {
					move1();
					if(board[b_y][b_x]=='O') {
						break;
					}
					if(board[r_y][r_x]=='O') {
						ans = Math.min(ans, i + 1);
						break;
					}
				} else if (t == 2) {
					move2();
					if(board[b_y][b_x]=='O') {
						break;
					}
					if(board[r_y][r_x]=='O') {
						ans = Math.min(ans, i + 1);
						break;
					}
				} else if (t == 3) {
					move3();
					if(board[b_y][b_x]=='O') {
						break;
					}
					if(board[r_y][r_x]=='O') {
						ans = Math.min(ans, i + 1);
						break;
					}
				}
			}
		}
		if (ans == 987564321) {
			ans = -1;
		}
		System.out.println(ans);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

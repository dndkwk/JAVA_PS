package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935 {

	static int N, M, R;
	static int[][] board = new int[101][101];
	static int[][] temp = new int[101][101];
	
	static void sol1() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j]=temp[N-i-1][j];
			}
		}
		
	}

	static void sol2() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j]=temp[i][M-j-1];
			}
		}
	}

	static void sol3() {
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				board[i][j]=temp[N-j-1][i];
			}
		}
		
		int t=N;
		N=M;
		M=t;
		
	}

	static void sol4() {
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				board[i][j]=temp[j][M-i-1];
			}
		}
		
		int t=N;
		N=M;
		M=t;
	}

	static void sol5() {
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				board[i][j]=temp[i+N/2][j];
				board[i+N/2][j]=temp[i+N/2][j+M/2];
				board[i+N/2][j+M/2]=temp[i][j+M/2];
				board[i][j+M/2]=temp[i][j];
			}
		}
	}

	static void sol6() {
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				board[i][j]=temp[i][j+M/2];
				board[i][j+M/2]=temp[i+N/2][j+M/2];
				board[i+N/2][j+M/2]=temp[i+N/2][j];
				board[i+N/2][j]=temp[i][j];
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int r = 0; r < R; r++) {
			int num = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j]=board[i][j];
				}
			}
			switch (num) {
			case 1:
				sol1();
				break;
			case 2:
				sol2();
				break;
			case 3:
				sol3();
				break;
			case 4:
				sol4();
				break;
			case 5:
				sol5();
				break;
			case 6:
				sol6();
				break;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}

	}
}

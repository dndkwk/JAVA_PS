package SAMSUNG;

import java.util.*;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import java.io.*;

public class BOJ_17822 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M, T;
	static int[][] board;
	static int[][] dump;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { -1, 1, 0, 0 };

	static void sol(int x, int k) {
		int[] temp = new int[M];
		for (int i = 1; i <= N; i++) {
			if (i % x != 0) {
				continue;
			}
			for (int j = 0; j < M; j++) {
				temp[j] = board[i][j];
			}

			for (int j = 0; j < M; j++) {
				board[i][j] = temp[(j + k) % M];
			}
		}
		
		boolean check=false;
		// 인접 수 제거
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == -1) {
					continue;
				}
				for (int p = 0; p < 4; p++) {
					int ni = i + dy[p];
					int nj = j + dx[p];
					if (ni < 1 || ni > N) {
						continue;
					}
					if (nj < 0) {
						nj = M - 1;
					}
					if (nj == M) {
						nj = 0;
					}
					if (board[ni][nj] == board[i][j]) {
						dump[ni][nj] = -1;
						dump[i][j] = -1;
						check=true;
					}
				}
			}
		}
//		show();
		if(check) {//바뀜
			//업데이트
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if(dump[i][j]==-1) {
						board[i][j]=-1;
						dump[i][j]=0;
					}
				}
			}
		}else{//안바뀜
			int cnt=0;
			double sum=0;
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if(board[i][j]!=-1) {
						sum+=board[i][j];
						cnt++;
					}
				}
			}
			if(cnt==0)return;
			sum/=cnt;
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if(board[i][j]==-1) {
						continue;
					}
					if(board[i][j]>sum) {
						board[i][j]--;
					}else if(board[i][j]<sum) {
						board[i][j]++;
					}
				}
			}
		}
		
		

	}
	
	static void show() {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		T = stoi(st.nextToken());
		board = new int[N + 1][M];
		dump = new int[N + 1][M];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = stoi(st.nextToken());
			}
		}
//		show();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken());
			int d = stoi(st.nextToken());
			int k = stoi(st.nextToken());
			if (d == 1) {
				sol(x, k);
			} else {
				sol(x, M - k);
			}
//			show();
		}
		
		int sum=0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j]!=-1) {
					sum+=board[i][j];
				}
			}
		}
		
		System.out.println(sum);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

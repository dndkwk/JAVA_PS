package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_12100 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[][] board;
	static int[][] temp;

	static void move0() {//위
		for(int i=0;i<N;i++) {
			int[] dump=new int[N];
			int idx=0;
			for(int j=0;j<N;j++) {
				if(temp[j][i]==0) {
					continue;
				}
				if(dump[idx]==0) {
					dump[idx]=temp[j][i];
				}else if(dump[idx]==temp[j][i]) {
					dump[idx]*=2;
					idx++;
				}else {
					++idx;
					dump[idx]=temp[j][i];
				}
			}
			
			for(int j=0;j<N;j++) {
				temp[j][i]=dump[j];
			}
		}
	}

	static void move1() {//우
		for(int i=0;i<N;i++) {
			int[] dump=new int[N];
			int idx=0;
			for(int j=N-1;j>=0;j--) {
				if(temp[i][j]==0) {
					continue;
				}
				if(dump[idx]==0) {
					dump[idx]=temp[i][j];
				}else if(dump[idx]==temp[i][j]) {
					dump[idx]*=2;
					idx++;
				}else {
					++idx;
					dump[idx]=temp[i][j];
				}
			}
			
			for(int j=N-1;j>=0;j--) {
				temp[i][j]=dump[N-1-j];
			}
		}
	}

	static void move2() {//아래
		for(int i=0;i<N;i++) {
			int[] dump=new int[N];
			int idx=0;
			for(int j=N-1;j>=0;j--) {
				if(temp[j][i]==0) {
					continue;
				}
				if(dump[idx]==0) {
					dump[idx]=temp[j][i];
				}else if(dump[idx]==temp[j][i]) {
					dump[idx]*=2;
					idx++;
				}else {
					++idx;
					dump[idx]=temp[j][i];
				}
			}
			
			for(int j=N-1;j>=0;j--) {
				temp[j][i]=dump[N-1-j];
			}
		}
	}

	static void move3() {//좌
		for(int i=0;i<N;i++) {
			int[] dump=new int[N];
			int idx=0;
			for(int j=0;j<N;j++) {
				if(temp[i][j]==0) {
					continue;
				}
				if(dump[idx]==0) {
					dump[idx]=temp[i][j];
				}else if(dump[idx]==temp[i][j]) {
					dump[idx]*=2;
					idx++;
				}else {
					++idx;
					dump[idx]=temp[i][j];
				}
			}
			
			for(int j=0;j<N;j++) {
				temp[i][j]=dump[j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		int mx=0;
		board=new int[N][N];
		temp=new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = stoi(st.nextToken());
			}
		}

		for (int k = 0; k < (int) Math.pow(4, 5); k++) {
			int bf = k;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp[i][j] = board[i][j];
				}
			}

			for (int i = 0; i < 5; i++) {
				int dir = bf % 4;
				bf /= 4;
				if (dir == 0) {
					move0();
				} else if (dir == 1) {
					move1();
				} else if (dir == 2) {
					move2();
				} else if (dir == 3) {
					move3();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mx=Math.max(mx, temp[i][j]);
				}
			}
		}
		System.out.println(mx);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

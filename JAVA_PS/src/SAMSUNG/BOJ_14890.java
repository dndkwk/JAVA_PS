package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_14890 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, L;
	static int[][] board;
	static int ans=0;

	static boolean sol1(int row) {
		int[] temp=new int[N];
		boolean[] vis=new boolean[N];
		for(int i=0;i<N;i++) {
			temp[i]=board[row][i];
		}
		
		for(int i=0;i<N-1;i++) {
			if(temp[i]==temp[i+1]) {
				continue;
			}
			if(temp[i]-temp[i+1]==1) {
				for(int j=i+1;j<=i+L;j++) {
					if(j>=N || vis[j] || temp[i+1]!=temp[j]) {
						return false;
					}
					vis[j]=true;
				}
			}else if(temp[i]-temp[i+1]==-1) {
				for(int j=i;j>i-L;j--) {
					if(j<0 || vis[j] || temp[i]!=temp[j]) {
						return false;
					}
					vis[j]=true;
				}
			}else {
				return false;
			}
		}
		
		return true;
	}

	static boolean sol2(int col) {
		int[] temp=new int[N];
		boolean[] vis=new boolean[N];
		for(int i=0;i<N;i++) {
			temp[i]=board[i][col];
		}
		
		for(int i=0;i<N-1;i++) {
			if(temp[i]==temp[i+1]) {
				continue;
			}
			if(temp[i]-temp[i+1]==1) {
				for(int j=i+1;j<=i+L;j++) {
					if(j>=N || vis[j] || temp[i+1]!=temp[j]) {
						return false;
					}
					vis[j]=true;
				}
			}else if(temp[i]-temp[i+1]==-1) {
				for(int j=i;j>i-L;j--) {
					if(j<0 || vis[j] || temp[i]!=temp[j]) {
						return false;
					}
					vis[j]=true;
				}
			}else {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		L = stoi(st.nextToken());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = stoi(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			if(sol1(i))ans++;
		}

		for (int j = 0; j < N; j++) {
			if(sol2(j))ans++;
		}
		
		
		System.out.println(ans);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

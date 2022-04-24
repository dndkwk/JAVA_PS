package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_15684 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M,H;
	static int[][] board;
	static int[] dy = { -1, 0, 1, 0 }; //U R D L 
	static int[] dx = { 0, 1, 0, -1 };
	static int ans=0;
	static boolean fin=false;
	
	
	static boolean check() {
		for(int i=0;i<M;i++) {
			int nx=i;
			int ny=0;
			while(ny < H) {
				if(board[ny][nx]==1) {
					nx++;
				}else if(board[ny][nx]==2){
					nx--;
				}
				ny++;
			}
			if(nx!=i) {
				return false;
			}
		}
		return true;
	}
	static void dfs(int cnt) {
		if(fin)return;
		if(cnt==ans) {
			if(check()) {
				fin=true;
			}
			return;
		}
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<M-1;j++) {
				if(board[i][j]==0 && board[i][j+1]==0) {
					board[i][j]=1;
					board[i][j+1]=2;
					
					dfs(cnt+1);
					
					board[i][j]=0;
					board[i][j+1]=0;
				}
			}			
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		M=stoi(st.nextToken());
		N=stoi(st.nextToken());
		H=stoi(st.nextToken());
		board=new int[H+1][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int a=stoi(st.nextToken())-1;
			int b=stoi(st.nextToken())-1;
			board[a][b]=1;
			board[a][b+1]=2;
			
		}
		
		
		for(int i=0;i<=3;i++) {
			ans=i;
			dfs(0);
			if(fin)break;
		}
		
		System.out.println(fin? ans:-1);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

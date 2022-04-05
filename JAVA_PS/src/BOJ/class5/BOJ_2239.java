package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_2239 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int[][] board=new int[9][9];
	static boolean flag;
	
	static void sol(int cnt) {
		if(cnt==81) {
			flag=true;
			return;
		}
		
		int r=cnt/9;
		int c=cnt%9;
		
		if(board[r][c]!=0) {
			sol(cnt+1);
		}else {
			for(int i=1;i<10;i++) {
				if(!valid(r,c,i)) {
					continue;
				}
				board[r][c]=i;
				sol(cnt+1);
				if(flag) return;
				board[r][c]=0;
			}
		}
		
	}
	static boolean valid(int r,int c,int n) {
		for(int i=0;i<9;i++) {
			if(board[i][c]==n || board[r][i]==n) {
				return false;
			}
		}
		int y=r/3*3;
		int x=c-c%3;
		for(int i=y;i<y+3;i++) {
			for(int j=x;j<x+3;j++) {
				if(board[i][j]==n) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		
		for(int i=0;i<9;i++) {
			String temp=br.readLine();
			for(int j=0;j<9;j++) {
				board[i][j]=temp.charAt(j)-'0';
			}
		}
		
		sol(0);
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1992 {
	static int N;
	static int[][] board;
	static StringBuilder sb;
	static boolean check(int y,int x,int n) {
		int pivot=board[y][x];
		for(int i=y;i<y+n;i++) {
			for(int j=x;j<x+n;j++) {
				if(pivot != board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void sol(int y,int x,int n) {
		if(check(y,x,n)) {
			sb.append(board[y][x]);
		}else {
			sb.append("(");
			sol(y,x,n/2);
			sol(y,x+n/2,n/2);
			sol(y+n/2,x,n/2);
			sol(y+n/2,x+n/2,n/2);
			sb.append(")");
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = null;
		sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		
		board=new int[N][N];
		
		for(int i=0;i<N;i++) {
			String temp=br.readLine();
			for(int j=0;j<N;j++){
				board[i][j]=temp.charAt(j)-'0';
			}
		}
		
		
		sol(0,0,N);
		
		System.out.println(sb);
		
	}
}

package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_2630 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정
	static int N;
	static int[][] board;
	static int[] bw=new int[2];
	
	static boolean check(int y,int x,int n) {
		int pivot=board[y][x];
		
		for(int i=y;i<y+n;i++) {
			for(int j=x;j<x+n;j++) {
				if(pivot!=board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void sol(int y,int x,int n) {
		if(check(y,x,n)) {
			bw[board[y][x]]++;
		}else {
			sol(y,x,n/2);
			sol(y,x+n/2,n/2);
			sol(y+n/2,x,n/2);
			sol(y+n/2,x+n/2,n/2);
		}
	}
	
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		board=new int[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		sol(0,0,N);
		
		System.out.println(bw[0]+"\n"+bw[1]);
		
		
		return;
	}

}

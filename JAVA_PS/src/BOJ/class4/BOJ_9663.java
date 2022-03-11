package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_9663 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[] board;
	static int cnt=0;
	
	public static boolean promising(int i) {
		int k=1;
		boolean flag=true;
		while(k<i && flag) {
			if(board[i]==board[k] || Math.abs(board[i]-board[k])==i-k) {
				flag=false;
			}
			k++;
		}
		
		return flag;
	}
	
	public static void check(int i) {
		if(promising(i)) {
			if(i==N) {
				cnt++;
			}else {
				for(int j=1;j<=N;j++) {
					board[i+1]=j;
					check(i+1);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		board=new int[N+1];
		check(0);
		System.out.println(cnt);
	}
}


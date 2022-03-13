package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_10830 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static long B;
	static int[][] board;
	static int MOD = 1000;
	
	public static int[][] calc(int[][] A,int[][] B){
		int[][] temp=new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					temp[i][j]+=(A[i][k]*B[k][j])%MOD;
				}
				temp[i][j]%=MOD;
			}
		}
		
		return temp;
	}
	
	public static int[][] sol(long cnt) {
		if(cnt==1) {
			return board;
		}
		
		int[][] result=sol(cnt/2);
		if(cnt%2==0) {
			return calc(result,result);
		}else {
			int[][] result2=calc(result,board);
			return calc(result,result2);
		}
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken()) % MOD;
			}
		}

		int[][] result = sol(B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
}

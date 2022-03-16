package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_11404 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M;
	static int[][] board;
	static int INF=1000000000;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		board=new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board[i][j]= i==j ? 0: INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			board[a-1][b-1]=Math.min(c, board[a-1][b-1]);
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					board[i][j]=Math.min(board[i][j],board[i][k]+board[k][j]);
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j]==INF) {
					sb.append(0+" ");
				}else {
					sb.append(board[i][j]+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}


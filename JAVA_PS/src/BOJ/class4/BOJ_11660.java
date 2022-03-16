package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_11660 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M;
	static int[][] board;
	
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		board=new int[N+1][N+1];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int num=Integer.parseInt(st.nextToken());
				board[i+1][j+1]=board[i + 1][j] + board[i][j + 1] - board[i][j] + num;
			}
		}
		
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int y1=Integer.parseInt(st.nextToken());
			int x1=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			
			int result=board[y2][x2]-board[y1-1][x2]-board[y2][x1-1]+board[y1 - 1][x1 - 1];
			sb.append(result+"\n");
		}
		
		System.out.println(sb);
		
	}
}

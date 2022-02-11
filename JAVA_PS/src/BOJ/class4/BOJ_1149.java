package BOJ.class4;

import java.io.*;
import java.util.*;

public class BOJ_1149 {
	
	static int N;
	static int[][] board;
	static int[] cost=new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		N=Integer.parseInt(br.readLine());
		board= new int[N+1][3];
		
		StringTokenizer st = null;
		
		board[0][0]=0;
		board[0][1]=0;
		board[0][2]=0;
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				cost[j]=Integer.parseInt(st.nextToken());
			}
			board[i][0]=Math.min(board[i-1][1],board[i-1][2] )+cost[0];
			board[i][1]=Math.min(board[i-1][0],board[i-1][2] )+cost[1];
			board[i][2]=Math.min(board[i-1][1],board[i-1][0] )+cost[2];
		}
		
		System.out.println(Math.min(Math.min(board[N][0], board[N][1]), board[N][2]));
		

	}
}

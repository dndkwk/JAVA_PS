package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_14938 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M,R;
	static int[] things;
	static int[][] board;
	static int MAX=987654321;
	
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		things=new int[N];
		board=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j) {
					board[i][j]=MAX;
				}
			}
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			things[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken())-1;
			int v=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken());
			board[u][v]=c;
			board[v][u]=c;
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(board[i][j]>board[i][k]+board[k][j]) {
						board[i][j]=board[i][k]+board[k][j];
					}
				}
			}
		}
		
		int result=0;
		for(int i=0;i<N;i++) {
			int temp=0;
			for(int j=0;j<N;j++) {
				if(board[i][j]<=M) {
					temp+=things[j];
				}
			}
			result=Math.max(result, temp);
		}
		
		System.out.println(result);
	}
}

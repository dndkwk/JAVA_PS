package BOJ.IM;

import java.util.*;
import java.io.*;

public class BOJ_10163 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N=Integer.parseInt(br.readLine());
		
		int[][] board=new int[1001][1001];
		
		for(int k=1;k<=N;k++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			int h=Integer.parseInt(st.nextToken());
			
			for(int i=y;i<y+h;i++) {
				for(int j=x;j<x+w;j++) {
					board[i][j]=k;
				}
			}
			
		}
		
		for(int k=1;k<=N;k++) {
			int cnt=0;
			for(int i=0;i<1001;i++) {
				for(int j=0;j<1001;j++) {
					if(board[i][j]==k) {
						cnt++;
					}
				}
			}
			sb.append(cnt+"\n");
		}
		
		System.out.println(sb);
	}

}









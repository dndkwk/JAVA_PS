package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_17779 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[][] board;
	static int mn=Integer.MAX_VALUE;
	static int total=0;
	
	static void sol(int x,int y,int d1,int d2) {
		boolean[][] vis=new boolean[N][N];
		for(int i=0;i<=d1;i++) {
			vis[x+i][y-i]=true;
			vis[x+d2+i][y+d2-i]=true;
		}
		
		for(int i=0;i<=d2;i++) {
			vis[x+i][y+i]=true;
			vis[x+d1+i][y-d1+i]=true;
		}
		
		int[] sum=new int[5];
		for(int i=0;i<x+d1;i++) {
			for(int j=0;j<=y;j++) {
				if(vis[i][j])break;
				sum[0]+=board[i][j];
			}			
		}
		
		for(int i=0;i<=x+d2;i++) {
			for(int j=N-1;j>y;j--) {
				if(vis[i][j])break;
				sum[1]+=board[i][j];
			}			
		}
		
		for(int i=x+d1;i<N;i++) {
			for(int j=0;j<y-d1+d2;j++) {
				if(vis[i][j])break;
				sum[2]+=board[i][j];
			}			
		}
		
		for(int i=x+d2+1;i<N;i++) {
			for(int j=N-1;j>=y-d1+d2;j--) {
				if(vis[i][j])break;
				sum[3]+=board[i][j];
			}			
		}
		
		sum[4]=total;
		for(int i=0;i<4;i++) {
			sum[4]-=sum[i];
		}
		Arrays.sort(sum);
		
		mn=Math.min(mn, sum[4]-sum[0]);
		
	}
	
	public static void main(String[] args) throws Exception {
		N=stoi(br.readLine());
		board=new int[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j]=stoi(st.nextToken());
				total+=board[i][j];
			}			
		}
		for(int x=0;x<N;x++) {
			for(int y=0;y<N;y++) {
				for(int d1=1;d1<N;d1++) {
					for(int d2=1;d2<N;d2++) {
						if(x+d1+d2>=N) continue;
						if(y-d1<0 || y+d2 >=N )continue;
						sol(x,y,d1,d2);
					}
				}
			}		
		}
		
		System.out.println(mn);
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

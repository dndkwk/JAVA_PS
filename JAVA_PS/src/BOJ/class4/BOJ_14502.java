package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_14502 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {-1,1,0,0};
	static int[][] board;
	static int result=0;
	
	static class pair{
		int y;
		int x;
		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	
	public static void sol() {
		boolean[][] visited= new boolean[N][M];
		Queue<pair> q=new LinkedList<pair>();
		int[][] temp=new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[i][j]=board[i][j];
				if(temp[i][j]==2) {
					q.add(new pair(i,j));
					visited[i][j]=true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			pair cur=q.poll();
			
			for(int i=0;i<4;i++) {
				int ny=cur.y+dy[i];
				int nx=cur.x+dx[i];
				
				if(ny <0||ny >=N || nx<0||nx>=M) {
					continue;
				}
				if(visited[ny][nx]==false && temp[ny][nx]==0) {
					temp[ny][nx]=2;
					visited[ny][nx]=true;
					q.add(new pair(ny,nx));
				}
			}
		}
		
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(temp[i][j]==0) {
					cnt++;
				}
			}
		}
		
		result=Math.max(result, cnt);
	}
	
	public static void wall(int cnt) {
		if(cnt==3) {
			sol();
		}else {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(board[i][j]==0) {
						board[i][j]=1;
						wall(cnt+1);
						board[i][j]=0;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		board=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		wall(0);
		
		System.out.println(result);
		
		
	}
}

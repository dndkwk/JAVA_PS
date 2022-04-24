package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_15683 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M;
	static int[][] board;
	static int[][] temp;
	static ArrayList<pair> arr;
	static int[] dy = { -1, 0, 1, 0 }; //U R D L 
	static int[] dx = { 0, 1, 0, -1 };
	
	static class pair{
		int y;
		int x;
		int type;
		public pair(int y, int x, int type) {
			super();
			this.y = y;
			this.x = x;
			this.type = type;
		}
	}
	
	static void cctv(int y,int x,int dir) {
		dir=dir%4;
		
		while(true) {
			int ny=y+dy[dir];
			int nx=x+dx[dir];
			if(ny < 0 || ny >= N || nx<0 || nx>=M ) {
				break;
			}
			if(temp[ny][nx]==6) {
				break;
			}
			
			if(temp[ny][nx]==0) {
				temp[ny][nx]=7;
			}
			y=ny;
			x=nx;
		}
		
	}

	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		
		arr=new ArrayList<>();
		board=new int[N][M];
		temp=new int[N][M];
		int ans=Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j]=stoi(st.nextToken());
				if(board[i][j]!=0 &&board[i][j]!=6) {
					arr.add(new pair(i,j,board[i][j]));
				}
			}			
		}
		
		for(int t=0;t<Math.pow(4, arr.size());t++) {
			int bf=t;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					temp[i][j]=board[i][j];
				}			
			}
			
			for(int i=0;i<arr.size();i++) {
				int dir=bf%4;
				bf=bf/4;
				int type=arr.get(i).type;
				int y=arr.get(i).y;
				int x=arr.get(i).x;
				if(type==1) {
					cctv(y,x,dir);
				}else if(type==2) {
					cctv(y,x,dir);
					cctv(y,x,dir+2);
				}else if(type==3) {
					cctv(y,x,dir);
					cctv(y,x,dir+1);
				}else if(type==4) {
					cctv(y,x,dir);
					cctv(y,x,dir+1);
					cctv(y,x,dir+2);
				}else if(type==5) {
					cctv(y,x,dir);
					cctv(y,x,dir+1);
					cctv(y,x,dir+2);
					cctv(y,x,dir+3);
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
			
			ans=Math.min(ans, cnt);
		}
		
		System.out.println(ans);
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_20056 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N, K, M;
	static ArrayList<ball>[][] board;
	static ArrayList<ball> list;
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static class ball {
		int r;
		int c;
		int m;
		int d;
		int s;
		public ball(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static void check() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j].size()==1) {
					board[i][j].clear();
				}
				if(board[i][j].size()<2) {
					continue;
				}
				
				int mSum=0,sSum=0;
				boolean check=true;//홀수인지 짝수인지 확인
				int pivot=board[i][j].get(0).d%2;
				
				for(ball fb: board[i][j]) {
					mSum+=fb.m;
					sSum+=fb.s;
					if(pivot!=fb.d%2) {
						check=false;
					}
					list.remove(fb);
				}
				
				int mM=mSum/5;
				int sz=board[i][j].size();
				board[i][j].clear();
				
				if(mM==0) {
					continue;
				}
				int nS=sSum/sz;
				if(check) {
					for(int dir=0;dir<8;dir+=2) {
						list.add(new ball(i,j,mM,nS,dir));
					}
				}else {
					for(int dir=1;dir<8;dir+=2) {
						list.add(new ball(i,j,mM,nS,dir));
					}
				}
			}			
		}
	}
	static void move() {
		for(ball fb:list) {
			int nr=(fb.r+N+dy[fb.d]*(fb.s%N))%N;
			int nc=(fb.c+N+dx[fb.d]*(fb.s%N))%N;
			fb.r=nr;
			fb.c=nc;
			board[nr][nc].add(fb);
		}
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());

		board = new ArrayList[N][N];
		list=new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board[i][j]=new ArrayList<>();
			}			
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r=stoi(st.nextToken())-1;
			int c=stoi(st.nextToken())-1;
			int m=stoi(st.nextToken());
			int s=stoi(st.nextToken());
			int d=stoi(st.nextToken());
			list.add(new ball(r,c,m,s,d));
		}
		for(int i=0;i<K;i++) {
			move();
			check();
		}
		int ans=0;
		for(ball tmp:list) {
			ans+=tmp.m;
		}
		System.out.println(ans);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
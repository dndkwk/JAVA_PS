package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_19238 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M,fuel;
	static int[][] board;
	static int tx,ty;
	static pair[] goal;
	static pair[] people;
	static int spend;
	static int[] dy= {0,0,1,-1};
	static int[] dx= {1,-1,0,0};
	
	static class pair{
		int y;
		int x;
		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static class tuple{
		int cnt;
		int y;
		int x;
		public tuple(int cnt, int y, int x) {
			super();
			this.cnt = cnt;
			this.y = y;
			this.x = x;
		}
	}
	
	static int nxt_idx(int y,int x) {
		//다음 가야할 인덱스와 그때 사용한 연료
		Queue<tuple> q=new LinkedList<tuple>();
		boolean[][] vis=new boolean[N][N];
		q.add(new tuple(0,y,x));
		vis[y][x]=true;
		int idx=-1;
		spend=987654321;
		//다음 사람 인덱스 찾기
		ArrayList<tuple> arr=new ArrayList<>();
		while(!q.isEmpty()) {
			tuple cur=q.poll();
			
			if(cur.cnt > spend) {
				continue;
			}
			
			if(board[cur.y][cur.x]!=0) {
				if(cur.cnt < spend) {
					spend=cur.cnt;
					idx=board[cur.y][cur.x];
				}else if(cur.cnt==spend) {
					// 행->열 순으로 비교
					if(cur.y < people[idx].y) {
						idx=board[cur.y][cur.x];
					}else if(cur.y==people[idx].y) {
						if(cur.x <people[idx].x) {
							idx=board[cur.y][cur.x];
						}
					}
				}
			}
			
			for(int i=0;i<4;i++) {
				int ny=cur.y+dy[i];
				int nx=cur.x+dx[i];
				if(ny < 0 || ny>=N || nx < 0 || nx>=N) {
					continue;
				}
				if(!vis[ny][nx] && board[ny][nx] != -1) {
					vis[ny][nx]=true;
					q.add(new tuple(cur.cnt+1,ny,nx));
				}
			}
			
		}
		
		return idx;
	}
	
	static void nxt_goal(int idx,int y,int x){
		Queue<tuple> q=new LinkedList<tuple>();
		boolean[][] vis=new boolean[N][N];
		q.add(new tuple(0,y,x));
		vis[y][x]=true;
		spend=987654321;
		
		while(!q.isEmpty()) {
			tuple cur=q.poll();

			if(goal[idx].y==cur.y && goal[idx].x==cur.x) {
				spend=cur.cnt;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int ny=cur.y+dy[i];
				int nx=cur.x+dx[i];
				if(ny < 0 || ny>=N || nx < 0 || nx>=N) {
					continue;
				}
				if(!vis[ny][nx] && board[ny][nx] != -1) {
					vis[ny][nx]=true;
					q.add(new tuple(cur.cnt+1,ny,nx));
				}
			}	
		}
	}
	
	static void show() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(board[i][j]+" ");
			}			
			System.out.println("");
		}
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		fuel = stoi(st.nextToken());
		
		board=new int[N][N];
		goal=new pair[M+1];
		people=new pair[M+1];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j]=stoi(st.nextToken());
				if(board[i][j]==1) {
					board[i][j]=-1;//벽을 -1로바꿈
				}
			}			
		}
		st=new StringTokenizer(br.readLine());
		ty=stoi(st.nextToken())-1;
		tx=stoi(st.nextToken())-1;
		for(int i=1;i<=M;i++) {
			st=new StringTokenizer(br.readLine());
			int y=stoi(st.nextToken())-1;
			int x=stoi(st.nextToken())-1;
			int gy=stoi(st.nextToken())-1;
			int gx=stoi(st.nextToken())-1;
			people[i]=new pair(y,x);
			goal[i]=new pair(gy,gx);
			board[y][x]=i;
		}
		
		int ans=fuel;
		for(int i=0;i<M;i++) {
			int nxt=nxt_idx(ty,tx);
			if(nxt==-1) {//손님을 찾아갈 수 없음
				ans=-1;
				break;
			}
			if(fuel < spend) {//손님한테까지 도착 못함
				ans=-1;
				break;
			}
			
			board[people[nxt].y][people[nxt].x]=0;
			fuel=fuel-spend;
			
			ty=people[nxt].y;
			tx=people[nxt].x;
			nxt_goal(nxt,ty,tx);
			if(fuel < spend) {//목적지까지 도착 못함
				ans=-1;
				break;
			}
			ty=goal[nxt].y;
			tx=goal[nxt].x;
			fuel=fuel-spend;
			//태우고 이동*2
			fuel=fuel+spend*2;
			ans=fuel;
		}
		
		System.out.println(ans);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_21609 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M;
	static int[][] board;

	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int score;
	static class group{
		int sz;
		int cnt; // 무지개 블록 개수
		int y; // 기준 y
		int x; // 기준 x
		public group(int sz,int cnt, int y, int x) {
			super();
			this.sz=sz;
			this.cnt = cnt;
			this.y = y;
			this.x = x;
		}
	}
	
	static class pair{
		int y;
		int x;
		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	static group getBlock(int y,int x){
		Queue<pair> q=new LinkedList<pair>();
		boolean[][] vis=new boolean[N][N];
		q.add(new pair(y,x));
		vis[y][x]=true;
		int color=board[y][x];
		int cnt=0; //무지개 블록 개수
		ArrayList<pair> list=new ArrayList<>();//일반 블록 리스트
		list.add(new pair(y,x));
		while(!q.isEmpty()) {
			pair cur=q.poll();
			
			for(int i=0;i<4;i++) {
				int ny=cur.y+dy[i];
				int nx=cur.x+dx[i];
				
				if(nx < 0 || nx>=N || ny < 0 || ny>=N) {
					continue;
				}
				
				if(vis[ny][nx]==false && (board[ny][nx]==0 || board[ny][nx]==color)) {
					vis[ny][nx]=true;
					if(board[ny][nx]==0) {
						cnt++;
					}else if(board[ny][nx]==color) {						
						list.add(new pair(ny,nx));
					}
					q.add(new pair(ny,nx));
				}
			}
		}
		int sz=cnt+list.size();
		Collections.sort(list,(p1,p2)->{
			if(p1.y==p2.y) {
				return p1.x-p2.x;
			}
			return p1.y-p2.y;
		});
		return new group(sz,cnt,list.get(0).y,list.get(0).x);
	} 
	static void remove(int y,int x) {
		Queue<pair> q=new LinkedList<pair>();
		boolean[][] vis=new boolean[N][N];
		q.add(new pair(y,x));
		vis[y][x]=true;
		int color=board[y][x];
		
		while(!q.isEmpty()) {
			pair cur=q.poll();
			board[cur.y][cur.x]=-2;
			for(int i=0;i<4;i++) {
				int ny=cur.y+dy[i];
				int nx=cur.x+dx[i];
				
				if(nx < 0 || nx>=N || ny < 0 || ny>=N) {
					continue;
				}
				
				if(vis[ny][nx]==false && (board[ny][nx]==0 || board[ny][nx]==color)) {
					vis[ny][nx]=true;
					q.add(new pair(ny,nx));
				}
			}
		}
	}
	
	static void gravity() {
		int[][] temp=new int[N][N];
		
		for(int col=0;col<N;col++) {
			int last=N-1;
			for(int row=N-1;row>=0;row--) {
				if(board[row][col]==-2) {
					continue;
				}
				if(board[row][col]==-1) {
					for(int blank=last;blank>row;blank--) {
						temp[blank][col]=-2;
					}
					temp[row][col]=-1;
					last=row-1;
					continue;
				}
				temp[last][col]=board[row][col];
				last--;
			}
			for(int row=last;row>=0;row--) {
				temp[row][col]=-2;
			}
		}
		
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				board[row][col]=temp[row][col];
			}			
		}
	}
	
	static void left() {
		int[][] temp=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				temp[i][j]=board[j][N-1-i];
			}			
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board[i][j]=temp[i][j];
			}			
		}	
	}
	static void show() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(board[i][j]+"   ");
			}			
			System.out.println("");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		
		board=new int[N][N];
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j]=stoi(st.nextToken());
			}			
		}
		score=0;
		ArrayList<group> groups=new ArrayList<group>(); 
		while(true){
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(board[i][j]>0) {
						group temp=getBlock(i,j);
						if(temp.sz>=2) {
							groups.add(temp);
						}
					}
				}				
			}
			
			if(groups.size()==0) {
				break;
			}
			
			//sort
			Collections.sort(groups,(g1,g2)->{
				if(g1.sz==g2.sz) {
					if(g1.cnt==g2.cnt) {
						if(g1.y==g2.y) {
							return g2.x-g1.x;
						}
						return g2.y-g1.y;
					}
					return g2.cnt-g1.cnt;
				}
				return g2.sz-g1.sz;
			});
			group target=groups.get(0);
//			System.out.println(target.sz+" "+target.y+" "+target.x);
//			show();
			//remove
			remove(target.y,target.x);
//			show();
			score+=(target.sz*target.sz);
			//gravity
			gravity();
//			show();
			//turn left
			left();
//			show();
			//gravity
			gravity();
//			show();
			groups.clear();
		}
		
		System.out.println(score);
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
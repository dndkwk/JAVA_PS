package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_17144 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/*  */
	static int R, C, T;
	static int[][] board;
	static List<pair> pivot;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	
	static class pair{
		int y;
		int x;
		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	
	static void spread() {
		int[][] temp=new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(board[i][j]!=0) {
					int cnt=0;
					for(int k=0;k<4;k++) {
						int ny=i+dy[k];
						int nx=j+dx[k];
						
						if(ny < 0 || ny >=R || nx<0|| nx>=C) {
							continue;
						}
						if(board[ny][nx]==-1) {
							continue;
						}
						cnt++;
						temp[ny][nx]+=board[i][j]/5;
					}
					temp[i][j]+=(board[i][j]-(board[i][j]/5)*cnt);
				}
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				board[i][j]=temp[i][j];
			}
		}
	}
	
	static void circulate() {
		ArrayList<Integer> up_dust=new ArrayList<>();
		ArrayList<Integer> down_dust=new ArrayList<>();
		pair up=pivot.get(0);
		pair down=pivot.get(1);
		
		int idx=0;
		for(int i=0;i<C;i++) {
			up_dust.add(board[up.y][i]);
		}
		for(int i=up.y-1;i>=0;i--) {
			up_dust.add(board[i][C-1]);
		}
		for(int i=C-2;i>=0;i--) {
			up_dust.add(board[0][i]);
		}
		for(int i=1;i<=up.y-1;i++) {
			up_dust.add(board[i][0]);
		}
		
		Collections.rotate(up_dust,1);
		up_dust.set(0,-1);
		up_dust.set(1,0);
		
		for(int i=0;i<C;i++) {
			board[up.y][i]=up_dust.get(idx);
			idx++;
		}
		for(int i=up.y-1;i>=0;i--) {
			board[i][C-1]=up_dust.get(idx);
			idx++;
		}
		for(int i=C-2;i>=0;i--) {
			board[0][i]=up_dust.get(idx);
			idx++;
		}
		for(int i=1;i<=up.y-1;i++) {
			board[i][0]=up_dust.get(idx);
			idx++;
		}
		
		
		//------
		
		
		idx=0;
		for(int i=0;i<C;i++) {
			down_dust.add(board[down.y][i]);
		}
		for(int i=down.y+1;i<R;i++) {
			down_dust.add(board[i][C-1]);
		}
		for(int i=C-2;i>=0;i--) {
			down_dust.add(board[R-1][i]);
		}
		for(int i=R-2;i>down.y;i--) {
			down_dust.add(board[i][0]);
		}
		
		Collections.rotate(down_dust,1);
		down_dust.set(0,-1);
		down_dust.set(1,0);
		
		for(int i=0;i<C;i++) {
			board[down.y][i]=down_dust.get(idx);
			idx++;
		}
		for(int i=down.y+1;i<R;i++) {
			board[i][C-1]=down_dust.get(idx);
			idx++;
		}
		for(int i=C-2;i>=0;i--) {
			board[R-1][i]=down_dust.get(idx);
			idx++;
		}
		for(int i=R-2;i>down.y;i--) {
			board[i][0]=down_dust.get(idx);
			idx++;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		
		board=new int[R][C];
		pivot=new ArrayList<pair>();
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
				if(board[i][j]==-1) {
					pivot.add(new pair(i,j));
				}
			}
		}
		
		for(int t=0;t<T;t++) {
			spread();
			circulate();
			
		}
		
		int sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(board[i][j]>0) {
					sum+=board[i][j];
				}
			}
		}
		
		System.out.println(sum);

	}
}


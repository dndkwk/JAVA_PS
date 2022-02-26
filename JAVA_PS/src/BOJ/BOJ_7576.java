package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_7576 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/*  */

	static int M, N;
	static int[][] board;
	static boolean[][] visited;
	static int answer = 0;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	static boolean check() {
		//익지않은 토마토 있는지 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] ==0) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void sol() {
		Queue<pair> q = new LinkedList<pair>();
		
		//익은 토마토 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) {
					q.add(new pair(i, j));
					visited[i][j]=true;
				}
			}
		}
		int cnt = q.size();
		
		while (!q.isEmpty()) {
			
			if(check()) {
				break;
			}
			
			//익은 토마토 개수 만큼 BFS
			while (cnt-- > 0) {
				pair cur=q.poll();
				
				for(int i=0;i<4;i++) {
					int ny=cur.y+dy[i];
					int nx=cur.x+dx[i];
					
					if(ny < 0 || ny>= N|| nx <0 || nx >=M) {
						continue;
					}
					
					//익지 않은 토마토만 넣을 수 있다.
					if(visited[ny][nx]==false && board[ny][nx]==0) {
						visited[ny][nx]=true;
						board[ny][nx]=1;
						q.add(new pair(ny,nx));
					}	
				}
			}
			
			//하루 지남
			answer++;
			cnt=q.size();
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited=new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sol();
		
		//남은 토마토 있는지 확인
		if(check()) {
			System.out.println(answer);
		}else{
			System.out.println("-1");
		}
		

	}
}

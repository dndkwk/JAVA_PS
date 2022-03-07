package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_2206 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M;
	static int[][] board;
	static boolean[][][] visited;
	static int ans = -1;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class node {
		int y;
		int x;
		int cnt;
		int wall;

		public node(int y, int x, int cnt, int wall) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.wall = wall;
		}

	}

	public static void bfs() {
		Queue<node> q = new LinkedList<node>();
		visited[0][0][1] = true;
		q.add(new node(0, 0, 1, 1));

		while (!q.isEmpty()) {
			node cur = q.poll();

			if (cur.y == N - 1 && cur.x == M - 1) {
				ans = cur.cnt;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int ny=cur.y+dy[i];
				int nx=cur.x+dx[i];
				if(ny <0 || ny>=N || nx<0 || nx>=M) {
					continue;
				}
				if(visited[ny][nx][cur.wall]==true) {
					continue;
				}
				
				if(cur.wall==1 && board[ny][nx]==1) {
					visited[ny][nx][cur.wall]=true;
					q.add(new node(ny,nx,cur.cnt+1,cur.wall-1));
				}
				
				if(board[ny][nx]==0) {
					visited[ny][nx][cur.wall]=true;
					q.add(new node(ny,nx,cur.cnt+1,cur.wall));
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j) - '0';
			}
		}

		bfs();
		
		System.out.println(ans);

	}
}

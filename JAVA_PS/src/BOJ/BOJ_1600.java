package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1600 {

	static int[] dy = { 0, 1, -1, 0 };
	static int[] dx = { 1, 0, 0, -1 };
	static int[] dy2 = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dx2 = { 2, 1, -1, -2, 2, 1, -1, -2 };
	static int K, W, H;
	static int[][] board;
	static boolean[][][] visited;

	static class pair {
		int y;
		int x;
		int k;
		int cnt;

		public pair(int y, int x, int k,int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.k = k;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int answer=-1;
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<pair> q = new LinkedList<>();
		visited[0][0][K] = true;
		q.add(new pair(0, 0, K,0));
		
		while (!q.isEmpty()) {
			pair cur = q.poll();
			if(cur.y==H-1 && cur.x==W-1) {
				answer=cur.cnt;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if (ny < 0 || ny >= H || nx < 0 || nx >= W) {
					continue;
				}
				if(!visited[ny][nx][cur.k] && board[ny][nx]==0) {
					visited[ny][nx][cur.k]=true;
					q.add(new pair(ny,nx,cur.k,cur.cnt+1));
				}
			}

			for (int i = 0; i < 8; i++) {
				int ny = cur.y + dy2[i];
				int nx = cur.x + dx2[i];
				if (ny < 0 || ny >= H || nx < 0 || nx >= W) {
					continue;
				}
				if(cur.k>=1&&!visited[ny][nx][cur.k-1] && board[ny][nx]==0) {
					visited[ny][nx][cur.k-1]=true;
					q.add(new pair(ny,nx,cur.k-1,cur.cnt+1));
				}
			}
		}
		System.out.println(answer);
	}
}
package BOJ.class4;

import java.io.*;
import java.util.*;

public class BOJ_17070 {

	static int N;
	static int[][] board;
	static int result = 0;

	static class pair {
		int y;
		int x;
		int type;

		public pair(int y, int x, int type) {
			this.y = y;
			this.x = x;
			this.type = type;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		Queue<pair> q = new LinkedList<pair>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		q.add(new pair(0, 1, 0));

		while (!q.isEmpty()) {
			pair cur = q.poll();
			if (cur.y == (N - 1) && cur.x == (N - 1)) {
				result++;
			}

			int ny = cur.y + 1;
			int nx = cur.x + 1;
			if(ny < N && nx < N) {
				if(board[ny][nx]==0 && board[ny-1][nx]==0 && board[ny][nx-1]==0){
					q.add(new pair(ny,nx,1));
				}
			}
			
			if(cur.type==0 || cur.type == 1) {
				ny = cur.y;
				nx = cur.x + 1;
				if(ny < N && nx < N) {
					if(board[ny][nx]==0){
						q.add(new pair(ny,nx,0));
					}
				}
			}
			
			if(cur.type==2 || cur.type==1) {
				ny = cur.y+1;
				nx = cur.x;
				if(ny < N && nx < N) {
					if(board[ny][nx]==0){
						q.add(new pair(ny,nx,2));
					}
				}
			}
		}
		
		System.out.println(result);

	}
}
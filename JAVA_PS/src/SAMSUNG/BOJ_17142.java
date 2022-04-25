package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_17142 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M;
	static int[][] board;
	static pair[] active;
	static ArrayList<pair> virus = new ArrayList<>();
	static ArrayList<pair> wall = new ArrayList<>();
	static int ans=-1;

	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static void sol() {
		Queue<pair> q = new LinkedList<pair>();
		int[][] vis = new int[N][N];
		for (pair cur : virus) {
			vis[cur.y][cur.x] = 2;//비활성 바이러스
		}
		for (pair cur : active) {
			q.add(new pair(cur.y, cur.x));
			vis[cur.y][cur.x] = 3;
		}
		for (pair cur : wall) {
			vis[cur.y][cur.x] = 1;
		}
		int time=0;
		boolean check=true;
		
		while (!q.isEmpty()) {
			int k = q.size();
			check=true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(vis[i][j]==0) {
						check=false;
					}
				}
			}
			if(check)break;
			while (k--> 0) {
				pair cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
						continue;
					}
					if (vis[ny][nx]==0) {
						q.add(new pair(ny, nx));
						vis[ny][nx]=1;
					}else if(vis[ny][nx]==2) {
						q.add(new pair(ny, nx));
						vis[ny][nx]=1;
					}
				}
			}
			time++;
		}

		if(check) {
			if(ans==-1) {
				ans=time;
			}else {
				ans=Math.min(ans, time);
			}
		}
		
	}

	static void dfs(int cnt, int start) {
		if (cnt == M) {
			sol();
			return;
		}
		for (int i = start; i < virus.size(); i++) {
			active[cnt] = virus.get(i);
			dfs(cnt + 1, i + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		board = new int[N][N];
		active = new pair[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = stoi(st.nextToken());
				if (board[i][j] == 2) {
					virus.add(new pair(i, j));
				} else if (board[i][j] == 1) {
					wall.add(new pair(i, j));
				}
			}
		}

		dfs(0, 0);
		System.out.println(ans);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

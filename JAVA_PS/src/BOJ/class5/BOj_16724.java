package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOj_16724 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M;
	static char[][] board;
	static int[] parents;

	static int findidx(int y, int x) {
		int ny = y;
		int nx = x;
		if (board[ny][nx] == 'U') {
			ny--;
		} else if (board[ny][nx] == 'D') {
			ny++;
		} else if (board[ny][nx] == 'L') {
			nx--;
		} else if (board[ny][nx] == 'R') {
			nx++;
		}

		return ny * M + nx;
	}

	static int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}

	static void union(int y, int x) {
		y = find(y);
		x = find(x);
		
		if(y>x) {
			parents[y]=x;
		}else {
			parents[x]=y;
		}
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		board = new char[N][M];
		parents = new int[N * M];

		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int idx = i * M + j;
				int nxt = findidx(i, j);
				if(find(idx) != find(nxt)) {
					union(idx,nxt);
				}
			}
		}
		
		HashSet<Integer> hs=new HashSet<>();
		for (int i = 0; i < parents.length; i++) {
			hs.add(find(i));
		}
		System.out.println(hs.size());

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
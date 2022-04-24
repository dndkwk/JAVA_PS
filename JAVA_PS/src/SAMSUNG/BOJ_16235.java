package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_16235 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M, K;
	static int[][] board;
	static int[][] food;
	static Queue<node> die;
	static LinkedList<node> trees = new LinkedList<>();
	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static class node {
		int age;
		int y;
		int x;

		public node(int age, int y, int x) {
			super();
			this.age = age;
			this.y = y;
			this.x = x;
		}
	}

	static void spring() {
		Iterator<node> iter=trees.iterator();
		while(iter.hasNext()) {
			node tree=iter.next();
			if (board[tree.y][tree.x] >= tree.age) {
				board[tree.y][tree.x] -= tree.age;
				tree.age++;
			} else {// 양분없음
				die.add(new node(tree.age/2,tree.y,tree.x));
				iter.remove();
			}
		}
	}

	static void summer() {
		while(!die.isEmpty()) {
			node cur=die.poll();
			board[cur.y][cur.x]+=cur.age;
		}
	}

	static void fall() {
		LinkedList<node> dump=new LinkedList<>();
		for(node tree:trees) {
			if(tree.age %5==0) {
				for (int j = 0; j < 8; j++) {
					int ny = tree.y + dy[j];
					int nx = tree.x + dx[j];
					if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
						continue;
					}
					dump.add(new node(1, ny, nx));
				}
			}
		}
		
		trees.addAll(0,dump);
		
	}

	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] += food[i][j];
			}
		}
	}


	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());

		board = new int[N][N];
		food = new int[N][N];
		die = new LinkedList<node>();
		for (int i = 0; i < N; i++) {
			Arrays.fill(board[i], 5);
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				food[i][j] = stoi(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken()) - 1;
			int y = stoi(st.nextToken()) - 1;
			int age = stoi(st.nextToken());
			trees.add(new node(age, x, y));
		}

		while (K-- > 0) {
			// 봄
			spring();
			// 여름
			summer();
			// 가을
			fall();
			// 겨울
			winter();
		}

		System.out.println(trees.size());
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}


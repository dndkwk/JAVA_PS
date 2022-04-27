package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_17837 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, K;
	static int[][] board;
	static node[] horses;
	static ArrayList<Integer>[][] arr;
	static int[] dy = { 0, 0, 0, -1, 1 };
	static int[] dx = { 0, 1, -1, 0, 0 };

	static class node {
		int dir;
		int y;
		int x;

		public node(int dir, int y, int x) {
			super();
			this.dir = dir;
			this.y = y;
			this.x = x;
		}
	}
	static int blue(int idx) {
		if(idx==1) {
			return 2;
		}else if(idx==2) {
			return 1;
		}else if(idx==3) {
			return 4;
		}else if(idx==4) {
			return 3;
		}
		return idx;
	}

	static boolean move() {
		for(int i=0;i<K;i++) {
			int dir=horses[i].dir;
			int y=horses[i].y;
			int x=horses[i].x;
			int ny=y+dy[dir];
			int nx=x+dx[dir];
			
			if(nx < 0 || nx>=N || ny<0 || ny>=N || board[ny][nx]==2) {//파랑
				horses[i].dir=blue(dir);
				dir=horses[i].dir;
				ny=y+dy[dir];
				nx=x+dx[dir];
				if(nx < 0 || nx>=N || ny<0 || ny>=N || board[ny][nx]==2) {
					continue;
				}
				if(board[ny][nx]!=2) {
					i--;
					continue;
				}
			}else if(board[ny][nx]==0||board[ny][nx]==1) {
				boolean pivot=false;
				ArrayList<Integer> temp=new ArrayList<>();
				for(int j=0;j<arr[y][x].size();j++) {
					int num=arr[y][x].get(j);
					if(num==i) {
						pivot=true;
						temp.add(i);
						arr[y][x].remove(j);
						j--;
						continue;
					}
					if(pivot) {
						horses[num].y=ny;
						horses[num].x=nx;
						temp.add(num);
						arr[y][x].remove(j);
						j--;
					}
				}
				horses[i].y=ny;
				horses[i].x=nx;
				
				if(board[ny][nx]==0) {
					for(int j=0;j<temp.size();j++) {
						arr[ny][nx].add(temp.get(j));
					}
				}else if(board[ny][nx]==1) {
					for(int j=temp.size()-1;j>=0;j--) {
						arr[ny][nx].add(temp.get(j));
					}
				}
				if(arr[ny][nx].size()>=4) {
					return true;
				}
				
				
			}
				
		}
		return false;
	}
	
	static void show() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j].size());
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		board = new int[N][N];
		arr = new ArrayList[N][N];
		horses = new node[K];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = stoi(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = stoi(st.nextToken()) - 1;
			int x = stoi(st.nextToken()) - 1;
			int dir = stoi(st.nextToken());
			horses[i] = new node(dir, y, x);
			arr[y][x].add(i);
		}
		int ans = -1;
		int t = 0;
		while (t <= 1000) {
			t++;
			if (move()) {
				ans = t;
				break;
			}
		}

		System.out.println(ans);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

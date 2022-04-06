package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_17471 {
	static int N;
	static int[] people;
	static boolean[][] board;
	static boolean[] subset;
	static int answer=987654321;
	
	static void sol(int cnt) {
		if (cnt == N) {
			ArrayList<Integer> arr1=new ArrayList<>();
			ArrayList<Integer> arr2=new ArrayList<>();
			for(int i=0;i<N;i++) {
				if(subset[i]) {
					arr1.add(i);
				}else {
					arr2.add(i);
				}
			}
			if(arr1.size()==0 || arr2.size()==0) {
				return;
			}
			Queue<Integer> q1=new LinkedList<>();
			boolean[] visited1=new boolean[N];
			q1.add(arr1.get(0));
			visited1[arr1.get(0)]=true;
			while(!q1.isEmpty()) {
				int cur=q1.poll();
				for(int i=0;i<arr1.size();i++) {
					if(board[cur][arr1.get(i)] && !visited1[arr1.get(i)]) {
						visited1[arr1.get(i)]=true;
						q1.add(arr1.get(i));
					}
				}
			}
			for(int n:arr1) {
				if(!visited1[n]) {
					return;
				}
			}
			
			
			Queue<Integer> q2=new LinkedList<>();
			boolean[] visited2=new boolean[N];
			q2.add(arr2.get(0));
			visited2[arr2.get(0)]=true;
			while(!q2.isEmpty()) {
				int cur=q2.poll();
				for(int i=0;i<arr2.size();i++) {
					if(board[cur][arr2.get(i)] && !visited2[arr2.get(i)]) {
						visited2[arr2.get(i)]=true;
						q2.add(arr2.get(i));
					}
				}
			}
			for(int n:arr2) {
				if(!visited2[n]) {
					return;
				}
			}
			int sum=0;
			for(int n:arr1) {
				sum+=people[n];
			}
			for(int n:arr2) {
				sum-=people[n];
			}
			
			answer=Math.min(Math.abs(sum),answer);
			
			return;
		}

		subset[cnt] = true;
		sol(cnt + 1);
		subset[cnt] = false;
		sol(cnt + 1);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		people = new int[N];
		board = new boolean[N][N];
		subset = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				board[i][Integer.parseInt(st.nextToken())-1] = true;
			}
		}

		sol(0);
		if(answer==987654321) {
			answer=-1;
		}
		System.out.println(answer);

	}
}

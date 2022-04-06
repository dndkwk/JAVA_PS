package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_2342 {
	static int N;
	static int[][][] cache;
	static int[] arr;
	
	static int move(int f, int t) {
		if (f == t)
			return 1;
		switch (f) {
		case 0:
			return 2;
		case 1:
			return t == 3 ? 4 : 3;
		case 2:
			return t == 4 ? 4 : 3;
		case 3:
			return t == 1 ? 4 : 3;
		case 4:
			return t == 2 ? 4 : 3;
		}
		return 0;
	}
	
	static int sol(int l,int r,int n) {
		if(n==N) {
			return 0;
		}
		if(cache[n][l][r]!=-1) {
			return cache[n][l][r];
		}
		
		cache[n][l][r]=Math.min(sol(arr[n],r,n+1)+move(l,arr[n]),sol(l,arr[n],n+1)+move(r,arr[n]));
		
		return cache[n][l][r];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		ArrayList<Integer> board = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			board.add(Integer.parseInt(st.nextToken()));
		}
		
		N = board.size() - 1;
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = board.get(i);
		}
		cache = new int[N][5][5];
		for(int i=0;i<N;i++) {
			for(int j=0;j<5;j++) {
				for(int k=0;k<5;k++) {
					cache[i][j][k]=-1;
				}
			}
		}
		
		System.out.println(sol(0,0,0));
		
		
	}
}
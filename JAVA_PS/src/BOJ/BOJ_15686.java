package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_15686 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/*  */

	static int N, M;
	static int[][] board;
	static List<pair> chicken;
	static List<pair> house;
	static List<pair> result;
	static boolean[] check;
	static int answer=Integer.MAX_VALUE;

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static void subset(int n) {
		if (n == chicken.size()) {
			List<pair> result=new ArrayList<pair>();
			for(int i=0;i<n;i++) {
				if(check[i]==true) {
					result.add(chicken.get(i));
				}
			}
			if(result.size() > M || result.size()==0) {
				return;
			}
			int sum=0;
			
			
			for(pair h: house) {
				int mn=987564231;
				for(pair rs: result) {
					int temp=Math.abs(rs.y-h.y)+Math.abs(rs.x-h.x);
					mn=Math.min(mn, temp);
				}
				sum+=mn;
			}
			answer=Math.min(sum, answer);
			
		} else {
			check[n] = true;
			subset(n+1);
			check[n]=false;
			subset(n+1);
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		chicken = new ArrayList<pair>();
		house = new ArrayList<pair>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					chicken.add(new pair(i, j));
				} else if (board[i][j] == 1) {
					house.add(new pair(i, j));
				}
			}
		}

		check = new boolean[chicken.size()];

		subset(0);
		
		System.out.println(answer);

	}
}


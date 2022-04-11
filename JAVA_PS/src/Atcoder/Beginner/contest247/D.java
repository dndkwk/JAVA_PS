package Atcoder.Beginner.contest247;

import java.io.*;
import java.util.*;

public class D {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	static class pair{
		int cnt;
		int val;
		public pair(int cnt, int val) {
			super();
			this.cnt = cnt;
			this.val = val;
		}
	}
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		ArrayList<pair> board = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			if (type == 1) {
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				board.add(new pair(c,x));
			} else if (type == 2) {
				int c = Integer.parseInt(st.nextToken());
				long sum=0;
				while(c!=0) {
					pair cur=board.get(0);
					board.remove(0);
					if(cur.cnt >c) {
						cur.cnt-=c;
						sum+=c*(long)cur.val;
						c-=c;
						board.add(0,cur);
					}else {//cur.cnt<c
						sum+=(long)cur.val*cur.cnt;
						c-=cur.cnt;
					}
				}
				sb.append(sum+"\n");
			}
		}
		//1000000000000000000
		System.out.println(sb);
	}

}

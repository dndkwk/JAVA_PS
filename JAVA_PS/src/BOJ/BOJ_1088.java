package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1088 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;

	static class pair {
		double val;
		int idx;
		int cnt;
		public pair(double val, int idx, int cnt) {
			this.val = val;
			this.idx = idx;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		PriorityQueue<pair> pq = new PriorityQueue<>((p1, p2) -> {
			if(p2.val > p1.val) {
				return 1;
			}else if(p2.val < p1.val){
				return -1;
			}else {
				return 0;
			}
			
		});
		Double mn = Double.MAX_VALUE;
		Double diff = Double.MAX_VALUE;
		ArrayList<Double> arr=new ArrayList<>(); 
		for (int i = 0; i < N; i++) {
			Double d = Double.parseDouble(st.nextToken());
			pq.add(new pair(d,i,1));
			arr.add(d);
			mn = Math.min(mn, d);
		}

		diff = pq.peek().val - mn;
		int m = Integer.parseInt(br.readLine());
		for (int i = 1; i <= m; i++) {
			pair temp = pq.poll();
			Double d=arr.get(temp.idx)/(temp.cnt+1);
			pq.add(new pair(d,temp.idx,temp.cnt+1));
			mn = Math.min(d, mn);
			diff = Math.min(diff, pq.peek().val - mn);
		}

		System.out.println(diff);

	}
}

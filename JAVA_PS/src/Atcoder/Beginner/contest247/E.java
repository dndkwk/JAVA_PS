package Atcoder.Beginner.contest247;

import java.io.*;
import java.util.*;

public class E {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static class pair{
		int val;
		int idx;
		public pair(int val, int idx) {
			super();
			this.val = val;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		int Y=Integer.parseInt(st.nextToken());
		int[] arr=new int[N];
		int cnt=0;
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int mn=arr[0],mx=arr[0];
		int start=0,end=0;
		PriorityQueue<pair> min_pq=new PriorityQueue<>((p1,p2)->p1.val-p2.val);
		PriorityQueue<pair> max_pq=new PriorityQueue<>((p1,p2)->p2.val-p1.val);
		
//		for(int i=0;i<N;i++) {
//			min_pq.add(new pair(arr[i],i));
//			max_pq.add(new pair(arr[i],i));
//			if(max_pq.peek().val==X) {
//				
//			}
//		}
		
		while(start <=end && end<arr.length) {
			min_pq.add(new pair(arr[end],end));
			max_pq.add(new pair(arr[end],end));
			
			if(max_pq.peek().val==X) {
				while(min_pq.peek().idx <start) {
					min_pq.poll();
				}
				if(min_pq.peek().val==Y) {
					cnt++;
				}
			}
			
			end++;
		}
		
		
		
		
	}

}

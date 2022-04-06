package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_2568 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int MAX = 500001;
	static pair[] arr;
	static int[] lis;
	static pair[] trace;
	static int[] cache = new int[MAX];

	static class pair {
		int a;
		int b;

		public pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) throws Exception {
		N = stoi(br.readLine());
		arr=new pair[N];
		lis=new int[N];
		trace=new pair[N];
		boolean[] visited=new boolean[MAX];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			arr[i] = new pair(a, b);
			visited[a] = true;
		}
		Arrays.sort(arr,(p1,p2)->p1.a-p2.a);

		int idx=0;
		lis[idx]=arr[0].b;
		trace[0]=new pair(0,arr[0].a);
		
		for(int i=1;i<N;i++) {
			if(lis[idx] < arr[i].b){
				lis[++idx]=arr[i].b;
				trace[i]=new pair(idx,arr[i].a);
			}else {
				int lower=Arrays.binarySearch(lis, 0,idx,arr[i].b);
				if(lower <0) lower=Math.abs(lower)-1;
				lis[lower]=arr[i].b;
				trace[i]=new pair(lower,arr[i].a);
			}
		}
		System.out.println(N-(idx+1));
		
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=N-1;i>=0;i--) {
			if(trace[i].a==idx) {
				list.add(trace[i].b);
				idx--;
			}
		}
		
		for(int a:list) {
			visited[a]=false;
		}
		
		for(int i=0;i<=500000;i++) {
			if(visited[i]) {
				sb.append(i+"\n");
			}
		}
		System.out.println(sb);
		
		
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

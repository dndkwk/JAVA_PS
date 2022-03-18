package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_12865 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,K;
	static class pair{
		int w;
		int v;
		public pair(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}
	}
	
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		pair[] p=new pair[N];
		int[] dp=new int[K+1];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int W=Integer.parseInt(st.nextToken());
			int V=Integer.parseInt(st.nextToken());
			p[i]=new pair(W,V);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=K;j>=1;j--){
				if(j-p[i].w>=0) {
					dp[j]=Math.max(dp[j], dp[j-p[i].w]+p[i].v);	
				}
			}
		}
		
		System.out.println(dp[K]);
	}
}

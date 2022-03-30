package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_1007 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N,K;
	static pair[] points;
	static boolean[] visited;
	static double ans;
	
	static int stoi(String str) {
		return Integer.parseInt(str);
	}
	static class pair{
		int y;
		int x;
		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	
	static void sol(int cnt,int idx) {
		if(cnt == N/2) {
			double x=0,y=0;
			
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					x-=points[i].x;
					y-=points[i].y;
				}else {
					x+=points[i].x;
					y+=points[i].y;
				}
			}
			ans=Math.min(ans, Math.sqrt(x*x+y*y));
			return;
		}
		
		if(idx==N) return;
		
		sol(cnt,idx+1);
		visited[idx]=true;
		sol(cnt+1,idx+1);
		visited[idx]=false;
	}
	
	public static void main(String[] args) throws Exception {
		int T=stoi(br.readLine());
		
		while(T-->0) {
			N=stoi(br.readLine());
			points=new pair[N];
			visited=new boolean[N];
			ans=Double.MAX_VALUE;
			for(int i=0;i < N ;i++) {
				st=new StringTokenizer(br.readLine());
				points[i]=new pair(stoi(st.nextToken()),stoi(st.nextToken()));
			}
			sol(0,0);
			System.out.println(ans);
		}	
		
	}
}

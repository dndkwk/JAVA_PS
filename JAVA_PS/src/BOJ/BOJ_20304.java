package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_20304 {

	static int N, M;
	static boolean[] visited;
	static int[] password;
	static int answer=0;
	static Queue<int[]> q;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		
		visited=new boolean[N+1];
		q=new LinkedList<>();
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int p=Integer.parseInt(st.nextToken());
			q.add(new int[] {p,0});
			visited[p]=true;
		}
		
		while(!q.isEmpty()) {
			int p=q.peek()[0];
			int cnt=q.peek()[1];
			q.poll();
			
			answer=Math.max(answer, cnt);
			for(int i=1;i<=N;i=i<<1) {
				int np=p&i;
				
				if(np > 0) {
					if(visited[p-i]==true) {
						continue;
					}
					q.add(new int[] {p-i,cnt+1});
					visited[p-i]=true;
				}else {
					if(p+i>N || visited[p+i]==true) {
						continue;
					}
					q.add(new int[] {p+i,cnt+1});
					visited[p+i]=true;
				}
			}
			
		}
		
		System.out.println(answer);
		

	}

}

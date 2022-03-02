package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_1865 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	
	static int N,M,W;
	static ArrayList<ArrayList<node>> board;
	static int MAX=987564321;
	
	static class node{
		int to;
		int cost;
		public node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
	}
	
	static boolean sol() {
		int[] dist=new int[N+1];
		Arrays.fill(dist, MAX);
		
		int s=0,e=0,t=0;
		dist[1]=0;
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<=N;j++) {
				for(int k=0;k<board.get(j).size();k++) {
					s=j;
					e=board.get(j).get(k).to;
					t=board.get(j).get(k).cost;
					if(dist[e] > dist[s]+t) {
						dist[e] = dist[s]+t;
					}
				}			
			}
		}
		
		for(int j=0;j<=N;j++) {
			for(int k=0;k<board.get(j).size();k++) {
				s=j;
				e=board.get(j).get(k).to;
				t=board.get(j).get(k).cost;
				if(dist[e] > dist[s]+t) {
					return true;
				}
			}			
		}
		
		
		
		return false;
	}
	

	public static void main(String[] args) throws Exception {
		int Tc=Integer.parseInt(br.readLine());		
		
		for(int t=0;t<Tc;t++) {
			st = new StringTokenizer(br.readLine());
			
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			
			board=new ArrayList<ArrayList<node>>();
			
			for(int i=0;i<=N;i++){
				board.add(new ArrayList<node>());
			}
			
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int u=Integer.parseInt(st.nextToken());
				int v=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				board.get(u).add(new node(v,c));
				board.get(v).add(new node(u,c));
			}
			
			for(int i=0;i<W;i++) {
				st = new StringTokenizer(br.readLine());
				int u=Integer.parseInt(st.nextToken());
				int v=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				board.get(u).add(new node(v,-c));
			}
			
			if(sol()) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());
	}
}


package SWEA;

import java.io.*;
import java.util.*;

public class Solution_1238 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/*  */
	
	static int n;
	static int[][] board;
	static boolean[] visited;
	static List<Integer> result;
	
	static void sol(int num){
		Queue<Integer> q=new LinkedList<Integer>();
		visited[num]=true;
		q.add(num);
		int cnt=q.size();
		
		while(!q.isEmpty()) {
			int answer=0;
			
			
			while(cnt-- > 0) {
				int cur=q.poll();
				
				for(int i=0;i<101;i++) {
					if(board[cur][i]==1 && !visited[i] ) {
						visited[i]=true;
						answer=Math.max(i, answer);
						q.add(i);
					}
				}
			}
			
			result.add(answer);
			cnt=q.size();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		for(int t=1;t<=10;t++) {

			board=new int[101][101];
			visited=new boolean[101];
			result=new ArrayList<Integer>();
			
			st=new StringTokenizer(br.readLine());
			int m=Integer.parseInt(st.nextToken());
			n=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<m/2;i++) {
				int u=Integer.parseInt(st.nextToken());
				int v=Integer.parseInt(st.nextToken());
				board[u][v]=1;
			}
			
			sol(n);
			
			System.out.println("#"+t+" "+result.get(result.size()-2));
			
			
		}
		
	}
}


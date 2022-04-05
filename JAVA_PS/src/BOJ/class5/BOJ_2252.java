package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_2252 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		StringBuilder sb=new StringBuilder();
		
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> board=new ArrayList<>();
		
		int[] indegree=new int[N];
		ArrayList<Integer> result=new ArrayList<>();
		Queue<Integer> q=new LinkedList<Integer>();
		
		for(int i=0;i<N;i++) {
			board.add(new ArrayList<Integer>());
		}
		
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			board.get(a).add(b);
			indegree[b]++;
		}
		for(int i=0;i<N;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			result.add(cur);
			for(int i=0;i<board.get(cur).size();i++) {
				if(--indegree[board.get(cur).get(i)]==0) {
					q.add(board.get(cur).get(i));
				}
			}
			
		}
		for(int n:result) {
			sb.append((n+1)+" ");
		}
		System.out.println(sb);
		
	}

}

package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_1766 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M;
	static int[] indegree;
	static int answer;
	static ArrayList<ArrayList<Integer>> board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st=new StringTokenizer(br.readLine());
		board=new ArrayList<>();
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		indegree=new int[N];
		
		for(int i=0;i<N;i++) {
			board.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int A=stoi(st.nextToken())-1;
			int B=stoi(st.nextToken())-1;
			board.get(A).add(B);
			indegree[B]++;
		}
		
		
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
	
		for(int i=0;i<N;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		ArrayList<Integer> result=new ArrayList<>();
		while(!q.isEmpty()) {
			int cur=q.poll();
			result.add(cur);
			for(int i=0;i<board.get(cur).size();i++) {
				int nxt=board.get(cur).get(i);
				--indegree[nxt];
				if(indegree[nxt] == 0) {
					q.add(nxt);
				}
			}
		}
		for(int n:result) {
			sb.append((n+1)+" ");
		}
		System.out.println(sb);
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

package BOJ.class5;
import java.util.*;
import java.io.*;

public class BOJ_2623 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		int[] indegree= new int[N];
		ArrayList<ArrayList<Integer>> board=new ArrayList<>();
		for(int i=0;i<N;i++) {
			board.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int k=stoi(st.nextToken());
			if(k==0)continue;
			int prev=stoi(st.nextToken())-1;
			for(int j=0;j<k-1;j++) {
				int curr=stoi(st.nextToken())-1;
				indegree[curr]++;
				board.get(prev).add(curr);
				prev=curr;
			}
		}
		
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<N;i++) {
			if(indegree[i]==0)q.add(i);
		}
		ArrayList<Integer> result=new ArrayList<>();
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			result.add(cur);
			for(int i=0;i<board.get(cur).size();i++) {
				if(--indegree[board.get(cur).get(i)]==0) {
					q.add(board.get(cur).get(i));
				}
			}
		}
		
		if(result.size()==N) {
			for(int t:result) {
				sb.append((t+1)+"\n");
			}
		}else {
			sb.append(0);
		}
		System.out.println(sb);
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

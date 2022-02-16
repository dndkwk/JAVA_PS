package BOJ.class5;

import java.io.*;
import java.util.*;

public class BOJ_1005 {

	static int N, K,W;
	static int[] cost;
	static int[] indegree;
	static int[] result;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			cost = new int[N+1];
			arr = new ArrayList[N+1];
			indegree=new int[N+1];
			result=new int[N+1];
			Queue<Integer> q=new LinkedList<Integer>();
			
			for (int i = 0; i <= N; i++) {
				arr[i] = new ArrayList<Integer>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X=Integer.parseInt(st.nextToken());
				int Y=Integer.parseInt(st.nextToken());
				arr[X].add(Y);
				indegree[Y]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			for(int i=1;i<=N;i++) {
				if(indegree[i]==0) {
					q.add(i);
				}
			}
			
			while(indegree[W]>0) {
				int p=q.peek();
				q.poll();
				for(int i: arr[p]) {
					result[i]=Math.max(result[i], result[p]+cost[p]);
					if(--indegree[i]==0) {
						q.add(i);
					}
				}
			}
			
			System.out.println(result[W]+cost[W]);

		}

	}

}

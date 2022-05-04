package BOJ.class5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	//
	static int N, M;
	static int[] parents;
	
	static int find(int x) {
		if(x==parents[x])
			return x;
		return parents[x]=find(parents[x]);
	}
	
	static void union(int y,int x) {
		y=find(y);
		x=find(x);
		
		parents[y]=y;
		parents[x]=y;
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		parents = new int[N];

		for (int i = 0; i < N; i++) {
			parents[i]=i;
		}
		int result=0;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = stoi(st.nextToken());
			int x = stoi(st.nextToken());
			if(find(y)==find(x)) {
				result=i;
				break;
			}else {
				union(y,x);
			}
		}
		
		System.out.println(result);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}

}

package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_16566 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	
	static int N,M,K;
	static int[] cards;
	static int[] parents;
	
	static int find(int x) {
		if(x==parents[x]) {
			return x;
		}
		return parents[x]=find(parents[x]);
	}
	static boolean union(int x,int y) {
		x=find(x);
		y=find(y);
		
		if(x==y) {
			return false;
		}
		
		parents[x]=y;
		
		return true;
	}
	
	static int upper(int target) {
		int start=0;
		int end=M;
		
		while(start < end) {
			int mid=(start+end)/2;
			if(cards[mid] <=target) {
				start=mid+1;
			}else{
				end=mid;
			}	
		}
		return end;
		
	}
	
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		K=stoi(st.nextToken());
		cards=new int[4000001];
		parents=new int[4000001];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			cards[i]=stoi(st.nextToken());
			parents[i]=i;
		}
		
		Arrays.sort(cards,0,M);
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			int cur=stoi(st.nextToken());
			int d=find(upper(cur));
			sb.append(cards[d]+"\n");
			union(d,d+1);
		}
		System.out.println(sb);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

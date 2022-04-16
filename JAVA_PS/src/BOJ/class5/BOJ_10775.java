package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_10775 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int G, P;
	static int[] parents;
	
	static int find(int x) {
		if(x==parents[x]) return x;
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

	public static void main(String[] args) throws Exception {
		G=Integer.parseInt(br.readLine());
		P=Integer.parseInt(br.readLine());
		
		parents=new int[G+1];
		for(int i=0;i<=G;i++) {
			parents[i]=i;
		}
		
		int ans=0;
		for(int i=0;i<P;i++) {
			int g=Integer.parseInt(br.readLine());
			int gate=find(g);
			if(gate==0) {break;}
			ans++;
			union(gate,gate-1);
		}
		System.out.println(ans);
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

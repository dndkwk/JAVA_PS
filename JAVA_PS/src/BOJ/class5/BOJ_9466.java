package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_9466 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,T,cnt;
	static int[] board;
	static boolean[] vis;
	static boolean[] fin;
	
	static void sol(int idx) {
		vis[idx]=true;
		int nxt=board[idx];
		
		if(!vis[nxt]) {
			sol(nxt);
		}else {
			if(!fin[nxt]) {
				cnt++;
				for(int i=nxt;i!=idx;i=board[i]) {
					cnt++;
				}
			}
		}
		
		fin[idx]=true;
	}
	
	public static void main(String[] args) throws Exception {
		T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			N=stoi(br.readLine());
			
			board=new int[N];
			vis=new boolean[N];
			fin=new boolean[N];
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				board[i]=stoi(st.nextToken())-1;
			}
			
			cnt=0;
			for(int i=0;i<N;i++) {
				if(vis[i]) continue;
				sol(i);
			}
			
			sb.append((N-cnt)+"\n");
			
		}
		System.out.println(sb);
		

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

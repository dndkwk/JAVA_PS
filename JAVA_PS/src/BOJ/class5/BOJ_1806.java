package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_1806 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M;
	static int[] board;
	
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		board=new int[N+1];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			board[i]=stoi(st.nextToken());
		}
		
		int low=0,high=0;
		int sum=0;
		int result=Integer.MAX_VALUE;
		
		while(low <= high && high <= N) {
			if(sum>=M && result>high-low) {
				result=high-low;
			}
			
			if(sum < M) {
				sum+=board[high];
				high++;
			}else {
				sum-=board[low];
				low++;
			}
		}
		
		if(result!=Integer.MAX_VALUE) {
			System.out.println(result);
		}else {
			System.out.println(0);
		}
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

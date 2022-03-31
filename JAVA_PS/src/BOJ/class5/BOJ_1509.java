package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_1509 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N, S;
	static int[] result;
	static boolean[][] cache;
	
	static void sol(String str,int len) {
		for(int i=0;i<len;i++) {
			for(int j=i;j<len;j++) {
				boolean flag=true;
				int s=i;
				int e=j;
				while(s<=e) {
					if(str.charAt(s++) != str.charAt(e--)) {
						flag=false;
						break;
					}
				}
				
				if(flag) {
					cache[i][j]=true;
				}
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		String str=br.readLine();
		N=str.length();
		result=new int[N+1];
		cache=new boolean[N+1][N+1];
		
		Arrays.fill(result, Integer.MAX_VALUE);
		
		sol(str,N);
		result[0]=0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=i;j++) {
				if(cache[j-1][i-1]) {
					result[i]=Math.min(result[i], result[j-1]+1);
				}
			}
		}
		
		System.out.println(result[N]);
		
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

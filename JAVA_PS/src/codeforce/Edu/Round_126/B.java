package codeforce.Edu.Round_126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	static int[] arr=new int[32769*2];
	static int MOD=32768;
	
	static int sol(int n) {
		if(n==0) {
			return 0;
		}
		if(arr[n]!=-1) {
			return arr[n];
		}
		arr[n]=Math.min(sol((n+1)%32768)+1, sol((n*2)%32768)+1);
		
		return arr[n];
	}
	
	public static void main(String[] args) throws Exception {
		
		int N = Integer.parseInt(br.readLine());
		int[] result=new int[N];
		Arrays.fill(arr, -1);
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(st.nextToken());
			result[i]=sol(num);
		}
		
		for(int i:result) {
			sb.append(i+" ");
		}
		System.out.println(sb);
	}

}

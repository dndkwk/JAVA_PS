package codeforce.Edu.Round_126;

import java.io.*;
import java.util.*;

public class C {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] arr;
	static long answer;
	
	static long sol(int x) {
		long odd=0,even=0;
		for(int i=0;i<N;i++) {
			int dif=x-arr[i];
			if(dif%2==1) odd++;
			even+=dif/2;
		}
		if(even>odd) {
			long need=(even-odd)/3;
			odd+=(2*need);
			even-=need;
		}
		
		if(odd==even) return 2*odd;
		else if(odd>even) return 2*odd-1;
		else if(even==odd+1) return 2*even;
		else return 2*odd+3;
	}
	
	
	public static void main(String[] args) throws Exception{

		int t=Integer.parseInt(br.readLine());
		while(t-->0) {
			N=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			arr=new int[N];
			int mx=0;
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				mx=Math.max(mx, arr[i]);
			}
			answer=Long.MAX_VALUE;
			answer=Math.min(answer, sol(mx));
			answer=Math.min(answer, sol(mx+1));
			sb.append(answer+"\n");
			
		}
		
		System.out.println(sb);
		

	}

}

package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_14888 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int mx=Integer.MIN_VALUE;
	static int mn=Integer.MAX_VALUE;
	static int[] arr;
	static int[] calc=new int[4];
	
	static void sol(int cnt,int sum) {
		if(cnt==N-1) {
			mx=Math.max(mx, sum);
			mn=Math.min(mn, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(calc[i]==0) {
				continue;
			}
			calc[i]--;
			if(i==0) {
				sol(cnt+1,sum+arr[cnt+1]);
			}else if(i==1) {
				sol(cnt+1,sum-arr[cnt+1]);
			}else if(i==2) {
				sol(cnt+1,sum*arr[cnt+1]);
			}else if(i==3) {
				sol(cnt+1,sum/arr[cnt+1]);
			}
			
			calc[i]++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		N=stoi(br.readLine());
		
		arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=stoi(st.nextToken());
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			calc[i]=stoi(st.nextToken());
		}
		
		sol(0,arr[0]);
		
		
		System.out.println(mx);
		System.out.println(mn);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

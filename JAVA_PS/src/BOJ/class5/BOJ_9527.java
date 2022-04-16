package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_9527 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	
	static long[] d;
	static long a,b;
	
	public static long sol(long x,long i) {
		long ans=x&1;
		for(;i>0;i--) {
			if((x & (1L <<i))!=0) {
				ans+=d[(int) (i-1)]+(x-(1L<<i)+1);
				x-=1L<<i;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		d=new long[55];
		d[0]=1;
		for(int i=1;i<55;i++) {
			d[i]=d[i-1]*2+(1L<<i);
		}
		st=new StringTokenizer(br.readLine());

		a=Long.parseLong(st.nextToken());
		b=Long.parseLong(st.nextToken());
		System.out.println(sol(b,54)-sol(a-1,54));
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

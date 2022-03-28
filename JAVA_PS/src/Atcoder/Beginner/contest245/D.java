package Atcoder.Beginner.contest245;

import java.io.*;
import java.util.*;

public class D {

	static int N, M;
	static int[] a;
	static int[] c;
	static int[] b;
	
	public static void sol() {
		for(int i=M;i>=0;i--) {
			b[i]=c[N+i]/a[N];
			for(int j=N;j>=0;j--) {
				c[j+i]-=(b[i]*a[j]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb=new StringBuilder();
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		a=new int[N+1];
		c=new int[M+N+1];
		b=new int[M+1];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<=N;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<=N+M;i++) {
			c[i]=Integer.parseInt(st.nextToken());
		}
		
		sol();
		for(int i=0;i<=M;i++) {
			System.out.print(b[i]+" ");
		}
		
	}

}

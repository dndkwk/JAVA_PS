package codeforce.CodeTon_Round_1;

import java.io.*;
import java.util.*;

public class A {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			N=Integer.parseInt(br.readLine());
			arr=new int[N];
			int mx=-1;
			int mn=Integer.MAX_VALUE;
			int answer1=0;
			int answer2=0;
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				if(arr[i] >= mx) {
					mx=arr[i];
					answer1=i+1;
				}
				if(arr[i] <= mn) {
					mn=arr[i];
					answer2=i+1;
				}
			}
			sb.append(answer2+" "+answer1+"\n");
		}
		
		
		System.out.println(sb);
	}
}

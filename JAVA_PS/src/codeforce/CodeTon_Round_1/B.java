package codeforce.CodeTon_Round_1;

import java.io.*;
import java.util.*;

public class B {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			arr=new int[N];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			boolean check=false;
			for(int i=0;i<arr.length;i++) {
				if(Arrays.binarySearch(arr, arr[i]+K)>=0) {
					check=true;
					break;
				}
			}
			if(check) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}

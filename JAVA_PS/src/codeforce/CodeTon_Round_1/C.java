package codeforce.CodeTon_Round_1;

import java.io.*;
import java.util.*;

public class C {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			N=Integer.parseInt(br.readLine());
			arr=new int[N];
			st=new StringTokenizer(br.readLine());
			boolean check1=true;
			
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				if(arr[i]==1) {
					check1=false;
				}
			}
			
			if(check1) {
				sb.append("YES\n");
			}else {
				Arrays.sort(arr);
				boolean check2=true;
				for(int i=1;i<N;i++) {
					if(arr[i-1]==arr[i]-1) {
						check2=false;
						break;
					}
				}
				if(check2) {
					sb.append("YES\n");
				}else {
					sb.append("NO\n");
				}
			}
			
			
		}
		
		System.out.println(sb);
		

	}

}

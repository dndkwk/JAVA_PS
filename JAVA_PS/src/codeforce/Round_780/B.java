package codeforce.Round_780;

import java.io.*;
import java.util.*;

public class B {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int n=Integer.parseInt(br.readLine());
			int[] arr=new int[n];
			int mx=0;
			int s_mx=0;
			int idx=0;
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				if(mx < arr[i]) {
					mx=arr[i];
					idx=i;
				}
			}
			
			for(int i=0;i<n;i++) {
				if(i!=idx) {
					s_mx=Math.max(s_mx, arr[i]);	
				}
			}
			if(mx-s_mx >=2) {
				sb.append("NO\n");
			}else {
				sb.append("YES\n");
			}
		}
		
		System.out.println(sb);
		
	}
}

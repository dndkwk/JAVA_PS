package codeforce.Round_780;

import java.io.*;
import java.util.*;

public class A {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			int one=Integer.parseInt(st.nextToken());
			int two=Integer.parseInt(st.nextToken());
			if(one==0) {
				sb.append("1\n");
			}else {
				long sum=one+two*2+1;
				sb.append(sum+"\n");
			}
		}
		
		System.out.println(sb);
		
	}
}

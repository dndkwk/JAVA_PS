package Atcoder.Beginner.contest248;

import java.io.*;
import java.util.*;

public class B {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		Long A=Long.parseLong(st.nextToken());
		Long B=Long.parseLong(st.nextToken());
		Long K=Long.parseLong(st.nextToken());
		int cnt=0;
		while(A<B) {
			A*=K;
			cnt++;
		}
		
		System.out.println(cnt);
		
		
	}

}

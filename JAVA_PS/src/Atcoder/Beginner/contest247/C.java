package Atcoder.Beginner.contest247;

import java.io.*;
import java.util.*;

public class C {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		String[] cache=new String[N+1];
		cache[1]="1";
		for(int i=2;i<=N;i++) {
			cache[i]=cache[i-1]+" "+i+" "+cache[i-1];
		}
		System.out.println(cache[N]);
	}

}

package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_11399 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[] P=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			P[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(P);
		int sum=0;
		for(int i=0;i<N;i++) {
			sum+=(P[i]*(N-i));
		}
		System.out.println(sum);
		return;
	}

}

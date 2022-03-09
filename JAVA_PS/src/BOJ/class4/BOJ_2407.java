package BOJ.class4;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class BOJ_2407 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		BigInteger n1=BigInteger.ONE;
		BigInteger n2=BigInteger.ONE;
		
		
		for(int i=0;i<M;i++) {
			n1=n1.multiply(new BigInteger(String.valueOf(N-i)));
			n2=n2.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		System.out.println(n1.divide(n2));

	}
}

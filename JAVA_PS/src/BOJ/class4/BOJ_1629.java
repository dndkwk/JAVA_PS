package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_1629 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static long A, B, C;

	static long sol(long a,long num) {
		if (num % 2 == 1) {
			return sol(a,num - 1)%C * a;
		} else if (num == 0) {
			return 1;
		} else if (num == 1) {
			return a%C;
		} else{
			long temp = sol(a,num / 2);
			return (temp%C )* (temp%C) ;
		}
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		long result = sol(A,B) % C;
		System.out.println(result);

	}
}


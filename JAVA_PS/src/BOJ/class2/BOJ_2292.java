package BOJ.class2;

import java.io.*;
import java.util.*;

public class BOJ_2292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int sum=0;
		for(int i=2;i<=N;sum++) {
			i+=6*sum;
		}
		if(N==1) sum=1;
		System.out.println(sum);
		
		
	}

}

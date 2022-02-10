package BOJ.class2;

import java.io.*;
import java.util.*;

public class BOJ_1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr= new int[N+1];
		arr[0]=1;
		arr[1]=1;
		for(int i=2;i<=Math.sqrt(N+1);i++) {
			for(int j=i*i;j<N+1;j+=i) {
				arr[j]=1;
			}
		}
		
		for(int i=M;i<N+1;i++) {
			if(arr[i]==0) {
				System.out.println(i);
			}
			
		}
		

	}

}

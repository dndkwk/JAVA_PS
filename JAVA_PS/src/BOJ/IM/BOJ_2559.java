package BOJ.IM;

import java.util.*;
import java.io.*;

public class BOJ_2559 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int sum=0;
		
		for(int i=0;i<K;i++) {
			sum+=arr[i];
		}
		
		int max=sum;
		
		for(int i=K;i<N;i++) {
			sum+=(arr[i]-arr[i-K]);
			max=Math.max(sum, max);
		}
		
		System.out.println(max);
		
		
	}

}










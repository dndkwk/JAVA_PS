package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_2473 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	
	
	public static void main(String[] args) throws Exception {
		int N=stoi(br.readLine());
		long[] arr=new long[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		
		long answer=Long.MAX_VALUE;
		long y=0,x=0,z=0;
		Arrays.sort(arr);
		
		for(int i=0;i<N-2;i++) {	
			int low=i+1,high=arr.length-1;
			while(low < high) {
				long sum=arr[i]+arr[low]+arr[high];
				if(Math.abs(sum) < answer) {
					answer=Math.abs(sum);
					y=arr[low];
					x=arr[high];
					z=arr[i];
				}
				if(sum<0) {
					low++;
				}else {
					high--;
				}
			}
		}
		
		System.out.println(z+" "+y+" "+x);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}


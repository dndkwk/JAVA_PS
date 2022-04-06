package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_2467 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	
	
	public static void main(String[] args) throws Exception {
		int N=stoi(br.readLine());
		int[] arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=stoi(st.nextToken());
		}
		int answer=Integer.MAX_VALUE;
		int y=0,x=0;
		Arrays.sort(arr);
		int low=0,high=arr.length-1;
		while(low < high) {
			int sum=arr[low]+arr[high];
			if(Math.abs(sum) < answer) {
				answer=Math.abs(sum);
				y=arr[low];
				x=arr[high];
			}
			if(sum<0) {
				low++;
			}else {
				high--;
			}
			
		}
		
		System.out.println(y+" "+x);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

package BOJ.class2;

import java.io.*;
import java.util.*;

public class BOJ_2805 {
	static int N,M;
	static int[] arr;
	
	static boolean sol(long mid) {
		long sum=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=mid) {
				sum+=(arr[i]-mid);
			}
		}
		
		if(sum>=M) {
			return true;
		}else{
			return false;
		}
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N];
		st= new StringTokenizer(br.readLine());
		long start=0,end=0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			end=Math.max(arr[i], end);
		}
		
		long result=0;
		while(start <= end) {
			long mid=(start+end)/2;
			
			if(sol(mid)) {
				result=Math.max(mid, result);
				start=mid+1;
			}else {
				end=mid-1;
			}
			
		}
		
		System.out.println(result);
		
		
		
	}

}


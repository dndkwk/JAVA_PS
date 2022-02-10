package BOJ.class2;

import java.io.*;
import java.util.*;

public class BOJ_2798 {
	static int result;
	static int[] arr;
	static int[] num=new int[3];
	static int M,N;
	
	static void sol(int cnt,int start) {
		if(cnt==3) {
			int sum=num[0]+num[1]+num[2];
			if(M>=sum) {
				if(result<=sum) {
					result=sum;
				}
			}
			return;
		}else {
			for(int i=start;i<arr.length;i++) {
				num[cnt]=arr[i];
				sol(cnt+1,i+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		result=0;
		
		arr=new int[N];
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		sol(0,0);
		
		System.out.println(result);
		
		
	}

}


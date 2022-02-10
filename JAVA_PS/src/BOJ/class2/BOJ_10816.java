package BOJ.class2;

import java.io.*;
import java.util.*;

public class BOJ_10816 {
	static int[] arr;
	static int lower_bound(int pivot) {
		int start=0,end=arr.length;
		while(start<end) {
			int mid=(start+end)/2;
			if(arr[mid]>=pivot) {
				end=mid;
			}else {
				start=mid+1;
			}
		}
		return start;
		
	}

	static int upper_bound(int pivot) {
		int start=0,end=arr.length;
		while(start<end) {
			int mid=(start+end)/2;
			if(arr[mid]>pivot) {
				end=mid;
			}else {
				start=mid+1;
			}
		}
		return end;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int pivot = Integer.parseInt(st.nextToken());
			int result = upper_bound(pivot) - lower_bound(pivot);
			sb.append(result+" ");
		}
		
		System.out.println(sb);

	}

}

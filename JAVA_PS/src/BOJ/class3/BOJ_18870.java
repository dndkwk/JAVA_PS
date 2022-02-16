package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_18870 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정
	
	public static void main(String[] args) throws Exception {
		int N=Integer.parseInt(br.readLine());
		
		int[] arr=new int[N];
		st=new StringTokenizer(br.readLine());
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] temp=arr.clone();
		Arrays.sort(arr);
		
		HashMap<Integer, Integer> hmap=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(!hmap.containsKey(arr[i])) {
				hmap.put(arr[i], cnt++);
			}
		}
		
		for(int i=0;i<N;i++) {
			sb.append(hmap.get(temp[i])).append(" ");
		}
		
		
		System.out.println(sb);
		
		return;
	}

}

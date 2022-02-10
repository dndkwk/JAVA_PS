package BOJ.class2;

import java.io.*;
import java.util.*;

public class BOJ_10989 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		int[] arr=new int[10001];
		
		for(int i=0;i<N;i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i=1;i<=10000;i++) {
			for(int j=0;j<arr[i];j++) {
				sb.append(i+"\n");
			}
		}
		
		System.out.println(sb);
	}

}


package SWEA;

import java.io.*;
import java.util.*;

public class Solution_1208 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[100];

		for (int t = 1; t <= 10; t++) {
			int dump_cnt = Integer.parseInt(br.readLine());
			int result=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			for(int i=0;i<dump_cnt;i++) {	
				arr[99]--;
				arr[0]++;
				Arrays.sort(arr);
				if((arr[99]-arr[0])<=1) {
					break;
				}
				
			}
			result= arr[99]-arr[0];
			System.out.println("#"+t+" "+result);
		}

	}
}

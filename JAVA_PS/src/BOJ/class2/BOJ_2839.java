package BOJ.class2;

import java.io.*;
import java.util.*;

public class BOJ_2839 {
	static final int MAX=987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st= new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		for (int i = 0; i <=N; i++) {
			arr[i] = MAX;
			if(i==3 || i==5) {
				arr[i]=1;
			}
		}
		for (int i = 6; i <= N; i++) {
			arr[i] = Math.min(arr[i - 3] + 1, arr[i - 5] + 1);
		}
		if (arr[N] >= MAX) {
			System.out.println(-1);
		} else {
			System.out.println(arr[N]);
		}

	}

}


package SWEA;

import java.io.*;

public class Solution_2805 {
	static int[][] farm = new int[49][49];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					farm[i][j] = Integer.parseInt(temp[j]);
				}
			}
			
			int m = (N - 1) / 2;
			for (int i = 0; i < (N - 1) / 2; i++) {
				for(int j=m-i;j<=m+i;j++) {
					sum+=farm[i][j];
				}
			}

			for (int i = 0; i < N ; i++) {
				sum+=farm[(N - 1) / 2][i];
			}
			
			for (int i = 0; i < (N - 1) / 2; i++) {
				for(int j=m-i;j<=m+i;j++) {
					sum+=farm[N-i-1][j];	
				}
			}
			
			System.out.println("#"+t+" "+sum);

		}

	}

}

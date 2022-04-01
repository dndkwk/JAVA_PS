package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_1562 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N, S;
	static long[][][] cache = new long[101][10][1 << 10];
	static int MOD = 1000000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = stoi(br.readLine());
		int result = 0;

		for (int i = 1; i <= 9; i++) {
			cache[1][i][1<<i]=1;
		}

		for (int n = 2; n <= N; n++) {
			for (int k = 0; k <= 9; k++) {
				for(int visit=0;visit<(1<<10);visit++) {
					int newVisit=visit|(1<<k);
					if(k==0) {
						cache[n][k][newVisit]+=cache[n-1][k+1][visit]%MOD;
					}else if(k==9) {
						cache[n][k][newVisit]+=cache[n-1][k-1][visit]%MOD;
					}else {
						cache[n][k][newVisit]+=cache[n-1][k+1][visit]%MOD+cache[n-1][k-1][visit]%MOD;;
					}
					
					cache[n][k][newVisit]%=MOD;
					
				}
			}
		}
		
		long sum=0;
		for(int i=0;i<=9;i++) {
			sum+=cache[N][i][(1<<10)-1]%MOD;
			sum%=MOD;
		}
		System.out.println(sum);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_9251 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	public static void main(String[] args) throws Exception {
		String a=br.readLine();
		String b=br.readLine();
		
		int[][] dp=new int[1001][1001];
		
		for(int i=1;i<=a.length();i++) {
			for(int j=1;j<=b.length();j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[a.length()][b.length()]);

	}
}

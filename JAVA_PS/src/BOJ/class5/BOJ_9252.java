package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_9252 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	public static void main(String[] args) throws Exception {
		String A=br.readLine();
		String B=br.readLine();
		int[][] dp=new int[B.length()+1][A.length()+1];
		
		for(int i=1;i<=B.length();i++) {
			for(int j=1;j<=A.length();j++) {
				if(A.charAt(j-1) !=B.charAt(i-1)) {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}else{
					dp[i][j]=dp[i-1][j-1]+1;
				}
			}
		}
		int len=dp[B.length()][A.length()];
		int i=B.length();
		int j=A.length();
		Stack<Character> s=new Stack<>();
		while(i>=1 && j>=1) {
			if(dp[i][j]==dp[i-1][j]) {
				i--;
			}else if(dp[i][j]==dp[i][j-1]) {
				j--;
			}else {
				s.add(B.charAt(i-1));
				i--;
				j--;
			}
		}
		System.out.println(len);
		while(!s.isEmpty()) {
			System.out.print(s.pop());
		}
		
		
	}
	

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

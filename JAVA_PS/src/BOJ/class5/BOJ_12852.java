package BOJ.class5;


import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	public static void main(String[] args) throws Exception {
		int N = stoi(br.readLine());
		int[] board = new int[N+2];
		int[] dp = new int[N+2];
		Arrays.fill(dp, 987654321);
		dp[N]=0;
		for (int i = N; i >= 1; i--) {
			dp[i] = Math.min(dp[i], dp[i+1]+1);
			if (i % 2 == 0) {
				dp[i/2]=Math.min(dp[i/2], dp[i]+1);
			}
			if (i % 3 == 0) {
				dp[i/3]=Math.min(dp[i/3], dp[i]+1);
			}
		}
		System.out.println(dp[1]);
//		for(int i=1;i<=N;i++) {
//			System.out.print(i+" ");
//		}
//		System.out.println("");
//		for(int i=1;i<=N;i++) {
//			System.out.print(dp[i]+" ");
//		}
//		System.out.println("");
		ArrayList<Integer> arr=new ArrayList<>();
		int idx=1;
		while(true) {
			arr.add(idx);
			if(idx==N) break; 
			if(idx*2 <=N && dp[idx*2]==dp[idx]-1) {
				idx=2*idx;
			}else if(idx*3<=N && dp[idx*3]==dp[idx]-1) {
				idx=3*idx;
			}else if(dp[idx+1]==dp[idx]-1) {
				idx+=1;
			}
		}
		for(int i=arr.size()-1;i>=0;i--) {
			sb.append(arr.get(i)+" ");
		}
		System.out.println(sb);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

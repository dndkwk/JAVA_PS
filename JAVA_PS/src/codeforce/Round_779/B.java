package codeforce.Round_779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		long mod=998244353;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n=Integer.parseInt(br.readLine());
			if(n%2==1) {
				sb.append("0\n");
			}else {
				long sum=1;
				for(int i=1;i<=n/2;i++) {
					sum*=i;
					sum*=i;
					sum%=mod;
				}
				sb.append(sum+"\n");
			}
			
		}
		System.out.println(sb);
	}
}

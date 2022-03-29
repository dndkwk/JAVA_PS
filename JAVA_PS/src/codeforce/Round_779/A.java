package codeforce.Round_779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			String temp = br.readLine();
			int cnt=0;
			for (int i = 0; i < temp.length()-1; i++) {
				if(temp.charAt(i)=='0' && temp.charAt(i+1)=='0') {
					cnt++;
					cnt++;
				}
			}
			for (int i = 0; i < temp.length()-2; i++) {
				if(temp.charAt(i)=='0' && temp.charAt(i+1)=='1'&& temp.charAt(i+2)=='0') {
					cnt++;
				}
			}
			
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
}

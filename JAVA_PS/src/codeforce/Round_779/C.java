package codeforce.Round_779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n=Integer.parseInt(br.readLine());
			int[] arr=new int[n];
			st=new StringTokenizer(br.readLine());
			int cnt=0;
			int idx=0;
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				if(arr[i]==1) {
					cnt++;
					idx=i;
				}
			}
			if(cnt!=1) {
				sb.append("NO\n");
			}else {
				boolean check=true;;
				for(int i=0;i<n-1;i++) {
					if(arr[(idx+i+1)%n]-arr[(idx+i)%n]>1) {
						check=false;
					}
				}
				if(check) {
					sb.append("YES\n");
				}else {
					sb.append("NO\n");
				}					
			}
		}
		System.out.println(sb);

	}

}

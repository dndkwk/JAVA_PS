package codeforce.Round_780;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int n=Integer.parseInt(br.readLine());
			int[] arr=new int[n];
			int[] cnt=new int[5];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				cnt[arr[i]+2]++;
			}
			if((cnt[0]+cnt[1])%2==0) {
				if(cnt[2]==0) {
					sb.append("0 0\n");
				}else {
					
				}
			}else {
				
			}
			
			
		}

	}

}

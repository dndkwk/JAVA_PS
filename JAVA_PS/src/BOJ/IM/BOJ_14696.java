package BOJ.IM;

import java.util.*;
import java.io.*;

public class BOJ_14696 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N=Integer.parseInt(br.readLine());
		
		
		for(int t=0;t<N;t++) {
			st=new StringTokenizer(br.readLine());
			int[] AAA=new int[5];
			int[] BBB=new int[5];
			char result='D';
			
			int n=Integer.parseInt(st.nextToken());
			for(int i=0;i<n;i++) {
				int temp=Integer.parseInt(st.nextToken());
				AAA[temp]++;
			}
			
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			for(int i=0;i<n;i++) {
				int temp=Integer.parseInt(st.nextToken());
				BBB[temp]++;
			}
			
			
			for(int i=4;i>0;i--) {
				if(AAA[i]>BBB[i]) {
					result='A';
					break;
				}else if(AAA[i]<BBB[i]) {
					result='B';
					break;
				}
			}
			
			System.out.println(result);
			
		}
		
		
	}

}








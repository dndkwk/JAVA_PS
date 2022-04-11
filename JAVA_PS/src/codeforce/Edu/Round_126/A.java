package codeforce.Edu.Round_126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			int[] b = new int[n];
			st=new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i]=Integer.parseInt(st.nextToken());
			}
			
			st=new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				b[i]=Integer.parseInt(st.nextToken());
			}
			long sum=0;
			for(int i=0;i<n;i++) {
				if(a[i]>b[i]) {
					int temp=a[i];
					a[i]=b[i];
					b[i]=temp;
				}
				if(i!=0){
					sum+=Math.abs(a[i]-a[i-1])+Math.abs(b[i]-b[i-1]);
				}
			}
			
			sb.append(sum+"\n");
			
		}
		System.out.println(sb);

	}

}

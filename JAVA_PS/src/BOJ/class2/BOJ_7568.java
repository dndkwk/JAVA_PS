package BOJ.class2;

import java.io.*;
import java.util.*;

public class BOJ_7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[] w=new int[N];
		int[] h=new int[N];
		int[] k=new int[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w[i]=Integer.parseInt(st.nextToken());
			h[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			int cnt=1;
			for(int j=0;j<N;j++) {
				if(i!=j) {
					if(w[j]>w[i] && h[j]>h[i]) {
						cnt++;
					}
				}
			}
			System.out.print(cnt+" ");
		}
		

	}

}


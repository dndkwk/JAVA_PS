package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_2096 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N = 0;
	static int[][] mx,mn;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		mx=new int[N][3];
		mn=new int[N][3];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int x3=Integer.parseInt(st.nextToken());
			if(i==0) {
				mx[i][0]=x1;
				mx[i][1]=x2;
				mx[i][2]=x3;
				
				mn[i][0]=x1;
				mn[i][1]=x2;
				mn[i][2]=x3;
			}else {
				mx[i][0]=Math.max(mx[i-1][0]+x1, mx[i-1][1]+x1);
				mx[i][1]=Math.max(mx[i-1][0]+x2, Math.max(mx[i-1][1]+x2, mx[i-1][2]+x2));
				mx[i][2]=Math.max(mx[i-1][1]+x3, mx[i-1][2]+x3);
				
				mn[i][0]=Math.min(mn[i-1][0]+x1, mn[i-1][1]+x1);
				mn[i][1]=Math.min(mn[i-1][0]+x2, Math.min(mn[i-1][1]+x2, mn[i-1][2]+x2));
				mn[i][2]=Math.min(mn[i-1][1]+x3, mn[i-1][2]+x3);
			}
		}
		
		int result1=Math.max(mx[N-1][0], Math.max(mx[N-1][1], mx[N-1][2]));
		int result2=Math.min(mn[N-1][0], Math.min(mn[N-1][1], mn[N-1][2]));
		
		System.out.println(result1+" "+result2);
	}
}

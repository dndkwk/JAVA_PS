package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229 {
	
	static int[] weight;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int result=-1;
			
			st=new StringTokenizer(br.readLine());
			weight=new int[N];
			for(int i=0;i<N;i++) {
				weight[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i!=j) {
						if(weight[i]+weight[j]<=M) {
							result=Math.max(result,weight[i]+weight[j] );
						}
					}
				}
			}
			
			System.out.println("#"+t+" "+result);
			
		}

	}

}

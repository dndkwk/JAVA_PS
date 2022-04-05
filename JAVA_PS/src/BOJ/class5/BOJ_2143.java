package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_2143 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int T,M,N;
	static int[] A;
	static int[] B;
	
	
	public static void main(String[] args) throws Exception {
		//st = new StringTokenizer(br.readLine());
		T=stoi(br.readLine());
		N=stoi(br.readLine());
		A=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i]=stoi(st.nextToken());
		}
		
		M=stoi(br.readLine());
		B=new int[M];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			B[i]=stoi(st.nextToken());
		}
		
		ArrayList<Integer> sum_A=new ArrayList<>();
		for(int i=0;i<N;i++) {
			int sum=0;
			for(int j=i;j>=0;j--) {
				sum+=A[j];
				sum_A.add(sum);
			}
		}
		
		ArrayList<Integer> sum_B=new ArrayList<>();
		for(int i=0;i<M;i++) {
			int sum=0;
			for(int j=i;j>=0;j--) {
				sum+=B[j];
				sum_B.add(sum);
			}
		}
		
		Collections.sort(sum_A);
		Collections.sort(sum_B);
		
		long result=0;
		int pa=0;
		int pb=sum_B.size()-1;
		
		while(pa<sum_A.size() && pb>=0) {
			long pivot=sum_A.get(pa)+sum_B.get(pb);
			
			if(pivot==T) {
				long a=sum_A.get(pa);
				long b=sum_B.get(pb);
				long acnt=0;
				long bcnt=0;
				while(pa<sum_A.size() && sum_A.get(pa)==a) {
					acnt++;
					pa++;
				}
				while(pb>=0 && sum_B.get(pb)==b) {
					bcnt++;
					pb--;
				}
				result+=acnt*bcnt;
			}else if(pivot<T){
				pa++;
			}else if(pivot>T) {
				pb--;
			}
		}
		
		System.out.println(result);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

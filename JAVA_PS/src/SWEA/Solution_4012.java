package SWEA;

import java.io.*;
import java.util.*;

public class Solution_4012 {
	
	static int T,N;
	static int[][] S;
	static ArrayList<Integer> temp;
	static boolean[] selected;
	static int ans;
	
	public static int sol(ArrayList<Integer> A,ArrayList<Integer> B) {
		int sumA=0;
		int sumB=0;
		for(int i: A) {
			for(int j: A) {
				if(i!=j) {
					sumA+=S[i][j];
				}
			}
		}
		
		for(int i: B) {
			for(int j: B) {
				if(i!=j) {
					sumB+=S[i][j];
				}
			}
		}
		
		return Math.abs(sumA-sumB);
	}
	
	static void comb(int start,int cnt ) {
		if(cnt==N/2) {
			ArrayList<Integer> A=new ArrayList<>();
			ArrayList<Integer> B=new ArrayList<>();
			for(int i=0;i<N;i++) {
				if(selected[i]) {
					A.add(i);
				}else {
					B.add(i);
				}
			}
			ans=Math.min(ans, sol(A,B));
		}else {
			for(int i=start;i<N;i++) {
				selected[i]=true;
				comb(i+1,cnt+1);
				selected[i]=false;
			}
		}	
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			
			S=new int[N][N];
			selected=new boolean[N];
			ans=Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					S[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			comb(0,0);
			
			System.out.println("#"+t+" "+ans);
		}
	}

}

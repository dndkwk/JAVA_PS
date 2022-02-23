package SWEA;

import java.io.*;
import java.util.*;

public class Solution_1247 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/*  */
	static int N;
	static int answer;
	static int[] X;
	static int[] Y;
	static pair company;
	static pair home;
	
	static class pair {
		int y;
		int x;
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static void sol(int y,int x,int flag,int sum) {
		//flag: 비트마스킹으로 방문했는지 확인
		//sum: 지금까지 온 거리
		if(flag == ((1<<N)-1)) {
			sum=sum+Math.abs(home.y-y)+Math.abs(home.x-x);
			answer=Math.min(answer, sum);
		}else {
			for(int i=0;i<N;i++) {
				if((flag & (1<<i)) == 0) {
					//방문했는지 확인하고 다음 단계로 넘어감
					sol(Y[i],X[i],(flag|1<<i),sum+Math.abs(Y[i]-y)+Math.abs(X[i]-x));
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			X = new int[N];
			Y = new int[N];
			answer=Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			//회사,집은 따로 저장
			company=new pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			home=new pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
			//각각의 좌표들을 배열에 저장
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
				Y[i] = Integer.parseInt(st.nextToken());
			}
			
			//회사부터 시작
			sol(company.y,company.x,0,0);
			
			System.out.println("#"+t+" "+answer);
		}
	}
}

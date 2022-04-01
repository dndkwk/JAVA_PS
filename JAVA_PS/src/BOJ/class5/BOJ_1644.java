package BOJ.class5;

import java.util.*;
import java.io.*;

public class BOJ_1644 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N;
	static boolean[] check;
	static ArrayList<Integer> prime;
	
	public static void erato(){
		check=new boolean[N+1];
		prime=new ArrayList<>();
		
		check[0]=check[1]=true;
		
		for(int i=2;i*i<=N;i++) {
			if(!check[i]) {
				for(int j=i*i;j<=N;j+=i) {
					check[j]=true;
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(!check[i]) {
				prime.add(i);
			}
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		N=stoi(br.readLine());
		
		erato();
		int low=0,high=0;
		int sum=0;
		int cnt=0;
		while(true) {
			if(sum>=N) {
				sum-=prime.get(low);
				low++;
			}else if(high==prime.size()) {
				break;
			}else {
				sum+=prime.get(high);
				high++;
			}
			if(N==sum) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

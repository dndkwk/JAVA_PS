package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_20055 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	
	static int N,K;
	static int[] dur;//내구성
	static ArrayList<Integer> arr;//돌아가는 인덱스
	static boolean[] pos;//로봇 위치
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		K=stoi(st.nextToken());
		
		dur=new int[2*N];
		pos=new boolean[2*N];
		arr=new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*N;i++) {
			dur[i]=stoi(st.nextToken());
		}
		
		for(int i=0;i<2*N;i++) {
			arr.add(i);
		}
		
		int time=1;
		int cnt=0;
		while(true) {
			Collections.rotate(arr, 1);
			int up=arr.get(0);
			int down=arr.get(N-1);
			
			if(pos[down]) {
				pos[down]=false;
			}
			
			for(int i=N-1;i>=0;i--) {
				int idx=arr.get(i);
				int nxt=arr.get(i+1);
				if(pos[idx]==true && dur[nxt]>=1 && pos[nxt]==false) {
					dur[nxt]--;
					pos[nxt]=true;
					pos[idx]=false;
					if(dur[nxt]==0) {
						cnt++;
					}
				}
			}
			
			if(pos[down]) {
				pos[down]=false;
			}
			
			if(dur[up]>=1 && pos[up]==false) {
				pos[up]=true;
				dur[up]--;
				if(dur[up]==0) {
					cnt++;
				}
			}
			
			if(cnt >= K) {
				break;
			}
			time++;
		}
		
		System.out.println(time);
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
package BOJ;

import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class BOJ_2491 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정
	

	public static void main(String[] args) throws Exception {
		
		int N=Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int cnt=1;
		int max=1;
		for(int i=0;i<N-1;i++) {
			if(arr[i]<=arr[i+1]) {
				cnt++;
			}else {
				cnt=1;
			}
			max=Math.max(max, cnt);
		}
		
		cnt=1;
		for(int i=0;i<N-1;i++) {
			if(arr[i]>=arr[i+1]) {
				cnt++;
			}else {
				cnt=1;
			}
			max=Math.max(max, cnt);
		}
		
		System.out.println(max);
		
		return;
	}

}

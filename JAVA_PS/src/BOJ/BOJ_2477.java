package BOJ;

import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class BOJ_2477 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정
	

	public static void main(String[] args) throws Exception {
		
		int[] arr=new int[6];
		int N=Integer.parseInt(br.readLine());
		
		for(int i=0;i<6;i++) {
			st=new StringTokenizer(br.readLine());
			int d= Integer.parseInt(st.nextToken());
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int w=0;
		int h=0;
		
		for(int i=0;i<6;i++) {
			if(i%2==0) {
				if(w<arr[i]) {
					w=arr[i];
				}
			}else {
				if(h<arr[i]) {
					h=arr[i];
				}
			}
		}
		
		int w2=0;
		int h2=0;
		
		for(int i=0;i<6;i++) {
			if(i%2==0) {
				if(h==arr[(i+5) % 6 ]+arr[(i+1)%6]) {
					w2=arr[i];
				}
			}else {
				if(w==arr[(i+5) % 6 ]+arr[(i+1)%6]) {
					h2=arr[i];
				}
			}
		}
		
		System.out.println(((w*h)-(w2*h2))*N);
		
		
		return;
	}

}

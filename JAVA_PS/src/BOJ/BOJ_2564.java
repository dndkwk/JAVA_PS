package BOJ;

import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class BOJ_2564 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정
	

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int C=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(br.readLine());
		
		int[] len=new int[N];
		int p=0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(a==1) {
				len[i]=b;
			}else if(a==2) {
				len[i]=C+R+(C-b);
			}else if(a==3) {
				len[i]=C+R+C+(R-b);
			}else if(a==4) {
				len[i]=C+b;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int dir=Integer.parseInt(st.nextToken());
		int x= Integer.parseInt(st.nextToken());
		
		if(dir==1) {
			p=x;
		}else if(dir==2) {
			p=C+R+(C-x);
		}else if(dir==3) {
			p=C+R+C+(R-x);
		}else if(dir==4) {
			p=C+x;
		}
		
		int sum=0;
		for(int i=0;i<N;i++) {
			int max=Math.max(p, len[i]);
			int min=Math.min(p, len[i]);
			sum+=Math.min(max-min, 2*(R+C)-max+min);
		}
		
		System.out.println(sum);
		return;
	}

}


package BOJ.IM;

import java.io.*;
import java.util.*;

public class BOJ_2628 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	
	public static void main(String[] args) throws Exception{
		List<Integer> R=new ArrayList<Integer>();
		List<Integer> C=new ArrayList<Integer>();
		
		R.add(0);
		C.add(0);
		st=new StringTokenizer(br.readLine());
		int w=Integer.parseInt(st.nextToken());
		int h=Integer.parseInt(st.nextToken());
		
		int N=Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int type=Integer.parseInt(st.nextToken());
			int num=Integer.parseInt(st.nextToken());
			
			if(type==0) {
				R.add(num);
			}else {
				C.add(num);
			}
		}
		
		R.add(h);
		C.add(w);
		
		Collections.sort(R);
		Collections.sort(C);
		
		int mx=0;
		
		for(int i=R.size()-1;i>0;i--) {
			int r=R.get(i)-R.get(i-1);
			for(int j=C.size()-1;j>0;j--) {
				int c=C.get(j)-C.get(j-1);
				mx=Math.max(mx, r*c);
			}
		}
		
		System.out.println(mx);
		

	}

}

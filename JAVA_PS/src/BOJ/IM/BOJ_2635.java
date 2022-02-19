package BOJ.IM;

import java.io.*;
import java.util.*;

public class BOJ_2635 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws Exception {
		
		int N=Integer.parseInt(br.readLine());
		int cnt=0;
		List<Integer> result=new ArrayList<>();
		
		for(int i=N;i>=0;i--) {
			List<Integer> temp=new ArrayList<>();
			temp.add(N);
			
			int num=N;
			int num2=i;
			while(true) {
				if(num<0) {
					break;
				}
				
				int num3=num;
				if(num2>=0)temp.add(num2);
				
				num=num2;
				num2=num3-num;
				
			}
			if(cnt<temp.size()){
				cnt=temp.size();
				result=temp;
			}	
		}
		System.out.println(cnt);
		for(Integer c: result)System.out.print(c+" ");
		
		
	}
}

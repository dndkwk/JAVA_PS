package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_1927 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정
	
	static int N,x;
	
	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			x=Integer.parseInt(br.readLine());
			if(x==0) {
				if(pq.isEmpty()) {
					sb.append(0+"\n");
				}else {
					sb.append(pq.poll()+"\n");
				}
			}else{
				pq.add(x);
			}
		}
		
		System.out.println(sb);
		
		
		
		return;
	}

}

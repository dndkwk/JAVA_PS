package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_11723 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정

	public static void main(String[] args) throws Exception {
		int M = Integer.parseInt(br.readLine());
		int status=0;
		sb=new StringBuilder();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			String temp=st.nextToken();
			if(temp.equals("add")) {
				int N=Integer.parseInt(st.nextToken());
				status=status | (1<<N);
			}else if(temp.equals("remove")) {
				int N=Integer.parseInt(st.nextToken());
				status = status & ~(1<<N);
			}else if(temp.equals("check")) {
				int N=Integer.parseInt(st.nextToken());
				if((status & (1<<N)) == 0) {
					sb.append(0+"\n");
				}else {
					sb.append(1+"\n");
				}
			}else if(temp.equals("toggle")) {
				int N=Integer.parseInt(st.nextToken());
				if((status & (1<<N)) == 0) {
					status=status | (1<<N);
				}else {
					status=status ^ (1<<N);
				}
			}else if(temp.equals("empty")) {
				status = status & 0;
			}else if(temp.equals("all")) {
				status = (1<<21)-1;
			}
		}
		
		System.out.println(sb);
		
		return;
	}

}

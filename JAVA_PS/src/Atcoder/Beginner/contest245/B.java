package Atcoder.Beginner.contest245;

import java.io.*;
import java.util.*;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		int N=Integer.parseInt(br.readLine());
		boolean[] check=new boolean[2001];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			check[Integer.parseInt(st.nextToken())]=true;
		}
		for(int i=0;i<=2000;i++) {
			if(!check[i]) {
				System.out.println(i);
				break;
			}
		}
	
	}
	

}

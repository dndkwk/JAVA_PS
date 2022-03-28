package Atcoder.Beginner.contest245;

import java.io.*;
import java.util.*;

public class A {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		int D=Integer.parseInt(st.nextToken());
		
		if(A>C) {
			System.out.println("Aoki");
		}else if(A<C){
			System.out.println("Takahashi");
		}else {
			if(B <= D) {
				System.out.println("Takahashi");
			}else {
				System.out.println("Aoki");
			}
		}
	}

}

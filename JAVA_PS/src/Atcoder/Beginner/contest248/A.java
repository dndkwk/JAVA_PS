package Atcoder.Beginner.contest248;

import java.io.*;
import java.util.*;

public class A {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		boolean[] check=new boolean[10];
		String str=br.readLine();
		for(int i=0;i<str.length();i++) {
			check[str.charAt(i)-'0'] = true;
		}
		for(int i=0;i<check.length;i++) {
			if(!check[i]) {
				System.out.println(i);
				break;
			}
		}

	}

}

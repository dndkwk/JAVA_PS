package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_9935 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	
	
	
	public static void main(String[] args) throws Exception {
		String str=br.readLine();
		String explosion=br.readLine();
		char[] output=new char[str.length()];
		int idx=0;
		
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(explosion.charAt(explosion.length()-1)==c) {
				if(idx < explosion.length()-1) {
					output[idx++]=c;
				}else {
					boolean check=true;
					for(int j=idx-1,k=explosion.length()-2;k>=0;k--,j--) {
						if(output[j]!=explosion.charAt(k)) {
							check=false;
							break;
						}
					}
					if(check) {
						idx=idx-(explosion.length()-1);
					}else {
						output[idx++]=c;
					}
				}
			}else {
				output[idx++]=c;
			}
		}
		
		if(idx==0) {
			sb.append("FRULA");
		}else {
			for(int i=0;i<idx;i++) {
				sb.append(output[i]);
			}
		}
		
		System.out.println(sb);
		
	}
}

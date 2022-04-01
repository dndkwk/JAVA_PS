package codeforce.Round_780;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			
			Stack<Character> s = new Stack<>();
			String str = br.readLine();
			
			for(int i=0;i<str.length();i++) {
				s.add(str.charAt(i));
				while (i+1 < str.length()) {
					i++;
					if(str.charAt(i)==s.peek()) {
						s.pop();
						break;
					}else {
						s.add(str.charAt(i));
					}	
				}
			}
			
			sb.append(s.size()+"\n");
		}
		
		
		
		System.out.println(sb);
		

	}

}

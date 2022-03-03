package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_1918 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	public static void main(String[] args) throws Exception {
		Stack<Character> s = new Stack<>();
		String str = br.readLine();
		String result = "";

		for (int i = 0; i < str.length(); i++) {
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				result += str.charAt(i);
			} else {
				switch (str.charAt(i)) {
				case '(':
					s.push(str.charAt(i));
					break;
				case '*':
				case '/':
					while (!s.empty() && (s.peek() == '*' || s.peek() == '/')) {
						result += s.peek();
						s.pop();
					}
					s.add(str.charAt(i));
					break;

				case '+':
				case '-':
					while (!s.empty() && s.peek() != '(') {
						result += s.peek();
						s.pop();
					}
					s.add(str.charAt(i));
					break;
				case')':
					while (!s.empty() && s.peek() != '(') {
						result += s.peek();
						s.pop();
					}
					s.pop();
					break;
				}
			}
		}
		
		while(!s.empty()) {
			result+=s.peek();
			s.pop();
		}
		
		System.out.println(result);

	}
}

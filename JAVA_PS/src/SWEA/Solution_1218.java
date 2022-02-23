package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String temp = br.readLine();
			int result=1;

			Stack<Character> s = new Stack<>();
			for (int i = 0; i < N; i++) {
				if (temp.charAt(i) == '(' || temp.charAt(i) == '[' || temp.charAt(i) == '{' || temp.charAt(i) == '<') {
					s.add(temp.charAt(i));
				} else {
					if (temp.charAt(i) == ')' && s.peek() != '(') {
						result=0;
						break;
					} else if (temp.charAt(i) == ']'&& s.peek() != '[') {
						result=0;
						break;
					} else if (temp.charAt(i) == '}'&& s.peek() != '{') {
						result=0;
						break;
					} else if (temp.charAt(i) == '>'&& s.peek() != '<') {
						result=0;
						break;
					}
					s.pop();
				}
			}
			
			if(!s.empty()) {
				result=0;
			}
			
			System.out.println("#"+t+" "+result);

		}

	}

}

package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1223 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {

			int N = Integer.parseInt(br.readLine());
			Stack<Character> s = new Stack<>();
			char[] temp = br.readLine().toCharArray();
			String post = "";

			for (int i = 0; i < temp.length; i++) {
				if (temp[i] != '+' && temp[i] != '*') {
					post += Character.toString(temp[i]);
				} else {
					if (temp[i] == '*') {
						s.push(temp[i]);
					} else {
						do {
							if (s.isEmpty())
								break;
							post += Character.toString(s.pop());
						} while (!s.isEmpty() && s.peek() != '+');
						s.push(temp[i]);
					}
				}
			}

			while (!s.isEmpty()) {
				post += Character.toString(s.pop());
			}

			Stack<Integer> result = new Stack<>();
			for (int i = 0; i < post.length(); i++) {
				if (post.charAt(i) != '+' && post.charAt(i) != '*') {
					result.push(post.charAt(i) - '0');
				} else {
					int op1 = result.pop();
					int op2 = result.pop();
					char oper = post.charAt(i);
					switch (oper) {
					case '*':
						result.push(op1 * op2);
						break;
					case '+':
						result.push(op1 + op2);
						break;
					}
				}
			}
			
			System.out.println("#"+t+" "+result.peek());

		}

	}

}

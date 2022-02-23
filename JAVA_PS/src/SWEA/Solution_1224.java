package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1224 {
	// 괄호 추가
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {

			int N = Integer.parseInt(br.readLine());
			Stack<Character> s = new Stack<>();
			char[] temp = br.readLine().toCharArray();
			String post = "";

			for (int i = 0; i < temp.length; i++) {
				if (temp[i] == '(' || temp[i] == '*') {
					s.push(temp[i]);
				} else if (temp[i] == '+') {
					if (s.isEmpty()) {
						s.push(temp[i]);
					} else {
						while (!s.isEmpty()) {
							if (s.peek() == '(') {
								s.push(temp[i]);
								break;
							} else {
								post+=Character.toString(s.pop());
							}
						}
					}

				} else if (temp[i] == ')') {
					while(!s.isEmpty()) {
						if(s.peek()=='(') {
							s.pop();
							break;
						}else {
							post+=Character.toString(s.pop());
						}
					}
				} else {
					post += Character.toString(temp[i]);
				}
			}

			while (!s.isEmpty()) {
				post += Character.toString(s.pop());
			}


			Stack<Integer> result = new Stack<>();
			for (int i = 0; i < post.length(); i++) {
				if (post.charAt(i) == '*') {
					int tmp = result.pop() * result.pop();
					result.push(tmp);
				} else if (post.charAt(i) == '+') {
					int tmp = result.pop() + result.pop();
					result.push(tmp);
				} else {
					result.push(post.charAt(i) - '0');
				}
			}

			System.out.println("#" + t + " " + result.peek());

		}

	}

}

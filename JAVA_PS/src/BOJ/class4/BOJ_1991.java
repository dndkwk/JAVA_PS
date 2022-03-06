package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_1991 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N = 0;
	static ArrayList<ArrayList<pair>> board;

	static class pair {
		int ch;
		boolean left;

		public pair(int ch, boolean left) {
			super();
			this.ch = ch;
			this.left = left;
		}

	}

	static public void preorder(int node) {
		sb.append((char)(node+'A'));
		for(int i=0;i<board.get(node).size();i++) {
			preorder(board.get(node).get(i).ch);
		}
		
	}

	static public void inorder(int node) {
		if(!board.get(node).isEmpty() && board.get(node).get(0).left==true) {
			inorder(board.get(node).get(0).ch);
		}
		sb.append((char)(node+'A'));
		
		if(!board.get(node).isEmpty() && board.get(node).get(0).left==false) {
			inorder(board.get(node).get(0).ch);
		}else if(board.get(node).size() == 2) {
			inorder(board.get(node).get(1).ch);
		}
		
	}

	static public void postorder(int node) {
		for(int i=0;i<board.get(node).size();i++) {
			postorder(board.get(node).get(i).ch);
		}
		sb.append((char)(node+'A'));
		
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		board = new ArrayList<ArrayList<pair>>();
		for (int i = 0; i < 26; i++) {
			board.add(new ArrayList<pair>());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			if (b != '.') {
				board.get(a - 'A').add(new pair(b - 'A', true));
			}

			if (c != '.') {
				board.get(a - 'A').add(new pair(c - 'A', false));
			}
		}

		preorder(0);
		System.out.println(sb.toString());
		sb.setLength(0);
		inorder(0);
		System.out.println(sb.toString());
		sb.setLength(0);
		postorder(0);
		System.out.println(sb.toString());

	}
}


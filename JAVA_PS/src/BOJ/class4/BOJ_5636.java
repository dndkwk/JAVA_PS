package BOJ.class4;

import java.util.*;
import java.io.*;

public class BOJ_5636 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static class Node{
		int num;
		Node left,right;
		
		Node(int num) {
            this.num = num;
        }

//        Node(int num, Node left, Node right) {
//            this.num = num;
//            this.left = left;
//            this.right = right;
//        }
        
        void insert(int n) {
            if (n < this.num) {
                if (this.left == null)
                    this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null)
                    this.right = new Node(n);
                else this.right.insert(n);
            }
        }
        
	}
	
	static void postOrder(Node node) {
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.num+"\n");
	}
	

	public static void main(String[] args) throws Exception {
		Node root=new Node(Integer.parseInt(br.readLine()));
		
		String input;
		while(true) {
			input=br.readLine();
			if(input==null || input.equals("")) {
				break;
			}
			root.insert(Integer.parseInt(input));
		}
		postOrder(root);
		System.out.println(sb);
		

	}
}

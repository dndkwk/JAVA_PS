package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2250 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,point=1,mxlevel=0;
	static List<Node> board=new ArrayList<>();
	static int[] levelMin;
	static int[] levelMax;
	static class Node{
		int cur;
		int parent;
		int left;
		int right;
		public Node(int cur,int left, int right) {
			this.cur = cur;
			this.parent = -1;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void inorder(int cur,int depth) {
		Node temp=board.get(cur);
		if(mxlevel < depth) {
			mxlevel=depth;
		}
		if(temp.left != -1) {
			inorder(temp.left,depth+1);
		}
		
		levelMin[depth]=Math.min(levelMin[depth], point);
		levelMax[depth]=point;
		point++;
		
		if(temp.right != -1) {
			inorder(temp.right,depth+1);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		levelMin=new int[N+1];
		levelMax=new int[N+1];
		int rootidx=0;
		for(int i=0;i<=N;i++) {
			board.add(new Node(i,-1,-1));
			levelMin[i]=N;
			levelMax[i]=0;
		}
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int num=Integer.parseInt(st.nextToken());
			int left=Integer.parseInt(st.nextToken());
			int right=Integer.parseInt(st.nextToken());
			board.get(num).left=left;
			board.get(num).right=right;
			if(left!= -1) {
				board.get(left).parent=num;
			}
			if(right!= -1) {
				board.get(right).parent=num;
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(board.get(i).parent == -1) {
				rootidx=i;
				break;
			}
		}
		inorder(rootidx,1);
		
		int ans_level=1;
		int ans_width=levelMax[1]-levelMin[1]+1;
		for(int i=2;i<=mxlevel;i++) {
			int w=levelMax[i]-levelMin[i]+1;
			if(ans_width < w) {
				ans_level=i;
				ans_width=w;
			}
		}
		System.out.println(ans_level+" "+ans_width);
	}
}

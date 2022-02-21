package BOJ.IM;

import java.util.*;
import java.io.*;

public class BOJ_2304 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	static int N;
	static int[] board = new int[1001];

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		int start=1000;
		int end=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			board[L]=H;
			start=Math.min(L, start);
			end=Math.max(L, end);
			
		}
		
		Stack<Integer> s=new Stack<>();
		
		int pivot= board[start];
		for(int l=start+1;l<=end;l++) {
			if(board[l]<pivot) {
				s.push(l);
			}else {
				while(!s.empty()) {
					int p=s.pop();
					board[p]=pivot;
				}
				pivot=board[l];
			}
		}
		s.clear();
		
		pivot= board[end];
		for(int l=end-1;l>=start;l--) {
			if(board[l]<pivot) {
				s.push(l);
			}else {
				while(!s.empty()) {
					int p=s.pop();
					board[p]=pivot;
				}
				pivot=board[l];
			}
		}
		int ans=0;
		for(int l=start; l <=end;l++) {
			ans+=board[l];
		}
		
		System.out.println(ans);
		
		
	}

}









package Atcoder.Beginner.contest248;


import java.util.*;
import java.io.*;

public class D {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//

	static int N, M, K;
	static ArrayList<ArrayList<Integer>> board = new ArrayList<>();

	public static int cnt(int di,int x) {
		int lo=-1,hi=board.get(x).size()-1;
		int sol=-1;
		
		while(lo<=hi) {
			int mid=(lo+hi)/2;
			int z=(mid==-1?-1:board.get(x).get(mid));
			if(z<=di || mid==-1) {
				lo=mid+1;
				sol=mid;
			}else {
				hi=mid-1;
			}
		}
		return sol;
	}

	public static void main(String[] args) throws Exception {
		ArrayList<Integer> temp = new ArrayList<>();
		N = stoi(br.readLine());
		for (int i = 0; i <= N; i++) {
			board.add(new ArrayList<Integer>());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			board.get(stoi(st.nextToken())).add(i);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(board.get(i));
		}

		int Q = stoi(br.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int L = stoi(st.nextToken());
			int R = stoi(st.nextToken());
			int X = stoi(st.nextToken());
			int cnt1=cnt(L-1,X);
			int cnt2=cnt(R,X);
			sb.append(cnt2-cnt1+"\n");
		}

		System.out.println(sb);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

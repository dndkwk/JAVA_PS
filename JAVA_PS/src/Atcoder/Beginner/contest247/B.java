package Atcoder.Beginner.contest247;

import java.io.*;
import java.util.*;

public class B {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		String[][] board=new String[N][2];
		String answer="Yes";
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			String family=st.nextToken();
			String given=st.nextToken();
			board[i][0]=family;
			board[i][1]=given;
		}
		for(int i=0;i<N;i++) {
			boolean fam_check=false;
			boolean giv_check=false;
			
			String family=board[i][0];
			String given=board[i][1];
			for(int j=0;j<N;j++) {
				if(i!=j) {
					if(family.equals(board[j][1]) || family.equals(board[j][0])) {
						fam_check=true;
					}
					if(given.equals(board[j][1]) || given.equals(board[j][0])) {
						giv_check=true;
					}
				}
			}
			
			if(fam_check && giv_check) {
				answer="No";
				break;
			}
		}
		
		
		System.out.println(answer);

	}

}

package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1289 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str= br.readLine();
		int T;
		T=Integer.parseInt(str);
		for(int test_case = 1; test_case <= T; test_case++){
			String temp=br.readLine();
			int cnt=0;
			if(temp.charAt(0)=='1') {
				cnt++;
			}
			for(int i=0;i<temp.length()-1;i++) {
				if(temp.charAt(i)!=temp.charAt(i+1)) {
					cnt++;
				}
			}
			
			System.out.println("#"+test_case+" "+cnt);
			
			
		}
		
		
		
	}

}

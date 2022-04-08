import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N,M;
	static char[][] board=new char[100][100];
	
	
	public static void main(String[] args) throws Exception {
		int T=stoi(br.readLine());
		
		while(T --> 0) {
			st=new StringTokenizer(br.readLine());
			N=stoi(st.nextToken());
			M=stoi(st.nextToken());
			for(int i=0;i<N;i++) {
				String temp=br.readLine();
				for(int j=0;j<M;j++) {
					board[i][j]=temp.charAt(j);
				}				
			}
			String key=br.readLine();
			
			
			
		}	
	}
	

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

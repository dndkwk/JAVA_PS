import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int T;
	static int H,W;
	static char[][] board=new char[103][103]; 
	
	
	public static void main(String[] args) throws Exception {
		T=Integer.parseInt(br.readLine());
		while(T-->0) {
			st=new StringTokenizer(br.readLine());
			H=stoi(st.nextToken());
			W=stoi(st.nextToken());
			for(int i=1;i<=H;i++) {
				String temp=br.readLine();
				for(int j=1;j<=W;j++) {
					board[i][j]=temp.charAt(j-1);
				}
			}
			for(int j=0;j<=W+1;j++) {
				board[0][j]='.';
				board[H+1][j]='.';				
			}
			for(int i=0;i<=H+1;i++) {
				board[i][0]='.';
				board[i][W+1]='.';				
			}
			
			
			
			
		}
		
		
		
	}
	

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

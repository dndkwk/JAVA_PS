import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//


	public static void main(String[] args) throws Exception {
		int N=5;
		int[][] board=new int[N][N];
		int[][] temp=new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board[i][j]=i*N+j;
			}			
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(board[i][j]+" ");
			}			
			System.out.println("");
		}
		
		System.out.println("");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				temp[i][j]=board[i][N-1-j];
			}			
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(temp[i][j]+" ");
			}			
			System.out.println("");
		}

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
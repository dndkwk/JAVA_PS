package BOJ.class4;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class BOJ_2448 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static char[][] ch;
	
	public static void sol(int n,int x,int y) {
		if (n == 3) {
			ch[y][x] = '*';

			ch[y+1][x-1] = '*';
			ch[y+1][x+1] = '*';

			ch[y+2][x-2] = '*';
			ch[y + 2][x - 1] = '*';
			ch[y + 2][x ] = '*';
			ch[y + 2][x +1] = '*';
			ch[y + 2][x + 2] = '*';
		
		}
		else {
			sol(n/2,x,y);
			sol(n/2,x-n/2+n,y+n/2);
			sol(n/2,x-n/2,y+n/2);
		}
		return;
	}
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		ch=new char[N][2*N-1];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < 2*N-1; ++j) {
				ch[i][j] = ' ';
			}
		}
		
		sol(N,N-1,0);
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < 2*N-1; ++j) {
				sb.append(ch[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
}

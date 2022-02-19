package BOJ.IM;

import java.util.*;
import java.io.*;

public class BOJ_10157 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	static int[][] board;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int C, R, K;
	static int cnt=0;
	static int X=-1,Y=-1;
	
	static void sol(int y,int x) {
		int dir=0;
		while(true) {
			cnt++;
			board[y][x]=cnt;
			if(cnt==K) {
				X=x;Y=y;
			}
			
			if(cnt==R*C) {
				break;
			}
			
			if(y+dy[dir] < 0 || y+dy[dir] >= R || x+dx[dir]<0 || x+dx[dir]>=C) {
				dir++;
				dir%=4;
			}
			
			if(board[y+dy[dir]][x+dx[dir]] != 0) {
				dir++;
				dir%=4;
			}
			
			y=y+dy[dir];
			x=x+dx[dir];
			
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		board = new int[R][C];
		sol(R-1,0);
		if(X==-1 && Y==-1) {
			System.out.println("0");	
		}else {
			System.out.println((X+1)+" "+ (R-Y));
		}

	}

}

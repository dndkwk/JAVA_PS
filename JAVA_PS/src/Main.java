import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	static int[][] board;
	static int[] dy = { -1, 1, 1, -1 };
	static int[] dx = { 1, 1, -1, -1 };
	static int W, H, t;
	static int cnt = 0;
	static int X = -1, Y = -1;
	
	
	static void sol(int y,int x) {
		int dir=0;
		cnt=0;
		while(true) {
			if(t==cnt) {
				X=x;Y=y;
				break;
			}
			if(x+dx[dir]==W && y+dy[dir]==H) {
				dir=
			}else if(x+dx[dir]==W) {
				
			}else if(y+dy[dir]==H) {
				
			}
			
			y=y+dy[dir];
			x=x+dx[dir];
		}
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		t=Integer.parseInt(br.readLine());
		
		sol(0,0);

		board = new int[H][W];
		
		System.out.println(X+" "+Y);

	}

}
package SWEA;

import java.io.*;

public class Solution_1954 {

	static int[] dx = {1,0,-1,0};// R D L U
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];

			int nx = 0, ny = 0;
			int dir=0;
			
			arr[0][0]=1;
			
			for (int i = 2; i <= N * N; i++) {
				nx=nx+dx[dir];
				ny=ny+dy[dir];
				if (nx >= N || nx < 0 || ny >= N || ny < 0) {
					nx=nx-dx[dir];
					ny=ny-dy[dir];
					dir++;
					dir%=4;
					
					nx=nx+dx[dir];
					ny=ny+dy[dir];
				}else if(arr[ny][nx]!=0) {
					nx=nx-dx[dir];
					ny=ny-dy[dir];
					dir++;
					dir%=4;
					
					nx=nx+dx[dir];
					ny=ny+dy[dir];
				}
				
				if(arr[ny][nx]!=0) {
					break;
				}
				
				
				arr[ny][nx]=i;
			}
			
			System.out.println("#"+t);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println("");
			}

		}

	}

}

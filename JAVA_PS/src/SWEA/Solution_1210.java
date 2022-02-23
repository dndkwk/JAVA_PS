package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210 {
	
	static int[][] lad=new int[100][100];
	static int[] dx= {-1,1};
	static int result=0;
	
	static int sol(int y,int x) {
		boolean road=false;
		while(true) {
			if(y==0) {break;}
			road=false;
			
			for(int i=0;i<2;i++) {
				int nx=x+dx[i];
				if(nx<0 || nx>=100) {
					continue;
				}
				if(lad[y][nx]==1) {
					road=true;
					x=nx;
					while(true) {
						nx=x+dx[i];
						if(nx<0 || nx>=100 || lad[y][nx]==0) {
							break;
						}else {
							x=nx;
						}
					}
				}
				if(road) {
					break;
				}
			}
			y--;
		}
		return x;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int t = 1; t <= 10; t++) {
			br.readLine();
			for(int i=0;i<100;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					lad[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int result=-1;
			
			for(int i=0;i<100;i++) {
				if(lad[99][i]==2) {
					result=sol(99,i);
					break;
				}
			}
			

			System.out.println("#" + t + " " +result);
		}
	}
}

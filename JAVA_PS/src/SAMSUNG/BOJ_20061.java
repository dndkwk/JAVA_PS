package SAMSUNG;


import java.util.*;
import java.io.*;

public class BOJ_20061 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int[][] blue = new int[10][4];
	static int[][] green = new int[10][4];
	static int score = 0;

	static void green_add(int y, int x, int t) {
		int mx = 9;
		if (t == 1) {
			for (int i = y; i < 10; i++) {
				if (green[i][x] != 0) {
					mx = i-1;
					break;
				}
			}
			green[mx][x]=1;
		} else if (t == 2) {
			for (int i = y; i < 10; i++) {
				if (green[i][x] != 0 || green[i][x+1]!=0) {
					mx = i-1;
					break;
				}
			}
			green[mx][x]=1;
			green[mx][x+1]=1;
		}else if(t==3) {
			for (int i = y; i < 10; i++) {
				if (green[i][x] != 0) {
					mx = i-1;
					break;
				}
			}
			green[mx-1][x]=1;
			green[mx][x]=1;
		}
		
		while(true) { //빙고 후 내리기
			int idx=green_check();
			if(idx==0) {
				break;
			}
			for(int i=idx;i>=4;i--) {
				for(int j=0;j<4;j++) {
					green[i][j]=green[i-1][j];
				}
			}
			for(int j=0;j<4;j++) {
				green[4][j]=0;
			}
		}
		
		
		//흐릿한 칸 내리기
		int idx=9;
		for(int i=4;i<=5;i++) {
			for(int j=0;j<4;j++) {
				if(green[i][j]==1) {
					idx=Math.min(idx, i);
				}
			}
		}
		if(idx==9) return;
		idx=6-idx;
		for(int i=9;i>=6;i--) {
			for(int j=0;j<4;j++) {
				green[i][j]=green[i-idx][j];
			}
		}
		for(int i=4;i<=5;i++) {
			for(int j=0;j<4;j++) {
				green[i][j]=0;
			}
		}
	}
	

	static int green_check() {// 빙고 있는지 확인
		for (int i = 9; i >= 6; i--) {
			if (green[i][0] == 0) {
				continue;
			}
			if (green[i][0] == green[i][1] && green[i][2] == green[i][3]) {
				if (green[i][1] == green[i][2]) {
					score++;
					return i;
				}
			}
		}
		return 0;
	}

	static void blue_add(int y, int x, int t) {
		int mx = 9;
		if (t == 1) {
			for (int i = y; i < 10; i++) {
				if (blue[i][x] != 0) {
					mx = i-1;
					break;
				}
			}
			blue[mx][x]=1;
		} else if (t == 2) {
			for (int i = y; i < 10; i++) {
				if (blue[i][x] != 0 || blue[i][x-1]!=0) {
					mx = i-1;
					break;
				}
			}
			blue[mx][x]=1;
			blue[mx][x-1]=1;
		}else if(t==3) {
			for (int i = y; i < 10; i++) {
				if (blue[i][x] != 0) {
					mx = i-1;
					break;
				}
			}
			blue[mx-1][x]=1;
			blue[mx][x]=1;
		}
		
		while(true) { //빙고 후 내리기
			int idx=blue_check();
			if(idx==0) {
				break;
			}
			for(int i=idx;i>=4;i--) {
				for(int j=0;j<4;j++) {
					blue[i][j]=blue[i-1][j];
				}
			}
			for(int j=0;j<4;j++) {
				blue[4][j]=0;
			}
		}
		
		
		//흐릿한 칸 내리기
		int idx=9;
		for(int i=4;i<=5;i++) {
			for(int j=0;j<4;j++) {
				if(blue[i][j]==1) {
					idx=Math.min(idx, i);
				}
			}
		}
		if(idx==9) return;
		idx=6-idx;
		for(int i=9;i>=6;i--) {
			for(int j=0;j<4;j++) {
				blue[i][j]=blue[i-idx][j];
			}
		}
		for(int i=4;i<=5;i++) {
			for(int j=0;j<4;j++) {
				blue[i][j]=0;
			}
		}
	}
	
	static int blue_check() {// 빙고 있는지 확인
		for (int i = 9; i >= 6; i--) {
			if (blue[i][0] == 0) {
				continue;
			}
			if (blue[i][0] == blue[i][1] && blue[i][2] == blue[i][3]) {
				if (blue[i][1] == blue[i][2]) {
					score++;
					return i;
				}
			}
		}
		return 0;
	}
	static void show() {
		System.out.println("G");
		for(int i=6;i<=9;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(green[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("B");
		for(int i=6;i<=9;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(blue[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) throws Exception {
		int N = stoi(br.readLine());
		
//		show();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = stoi(st.nextToken());
			int y = stoi(st.nextToken());
			int x = stoi(st.nextToken());
			int by=x;
			int bx=3-y;
			
			if (t == 1) {
				green_add(y, x, 1);
				blue_add(by,bx,1);
				
			} else if (t == 2) {
				green_add(y, x, 2);
				blue_add(by,bx,3);
			} else if (t == 3) {
				green_add(y, x, 3);
				blue_add(by,bx,2);
			}
//			show();
		}
		int cnt=0;
		for(int i=6;i<=9;i++) {
			for(int j=0;j<4;j++) {
				if(green[i][j]==1) {
					cnt++;
				}
				if(blue[i][j]==1) {
					cnt++;
				}
			}			
		}
		
		System.out.println(score+"\n"+cnt);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

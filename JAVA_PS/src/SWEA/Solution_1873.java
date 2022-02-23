package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873 {
	
	static int[] dx= {0,0,1,-1};// U D R L
	static int[] dy= {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			int x=0;
			int y=0;
			int dir=0;

			String[][] map = new String[H][W];
			for (int i = 0; i < H; i++) {
				String[] temp = br.readLine().split("");
				for (int j = 0; j < W; j++) {
					map[i][j] = temp[j];
					if (temp[j].equals(">")) {
						y = i;
						x = j;
						dir = 2;
					}else if (temp[j].equals("^")) {
						y = i;
						x = j;
						dir = 0;
					}else if (temp[j].equals("<")) {
						y = i;
						x = j;
						dir = 3;
					}else if (temp[j].equals("v")) {
						y = i;
						x = j;
						dir = 1;
					}
				}
			}
			
			
			int N = Integer.parseInt(br.readLine());
			String cmd = br.readLine();
			int ny=0,nx=0;
			
			
			for (int i = 0; i < N; i++) {
				switch (cmd.charAt(i)) {
				case 'U':
					dir=0;
					map[y][x]="^";
					nx=x+dx[0];
					ny=y+dy[0];
					if(nx<0 || nx>= W || ny<0 || ny>=H) {
						continue;
					}
					if(!map[ny][nx].equals(".")) {
						continue;
					}
					map[y][x]=".";
					x=nx;
					y=ny;
					map[y][x]="^";
					break;
				case 'D':
					dir =1;
					map[y][x]="v";
					nx=x+dx[1];
					ny=y+dy[1];
					if(nx<0 || nx>= W || ny<0 || ny>=H) {
						continue;
					}
					if(!map[ny][nx].equals(".")) {
						continue;
					}
					map[y][x]=".";
					x=nx;
					y=ny;
					map[y][x]="v";
					break;
				case 'L':
					dir =3;
					map[y][x]="<";	
					nx=x+dx[3];
					ny=y+dy[3];
					if(nx<0 || nx>= W || ny<0 || ny>=H) {
						continue;
					}
					if(!map[ny][nx].equals(".")) {
						continue;
					}
					map[y][x]=".";
					x=nx;
					y=ny;
					map[y][x]="<";				
					break;
				case 'R':
					dir =2;
					map[y][x]=">";
					nx=x+dx[2];
					ny=y+dy[2];
					if(nx<0 || nx>= W || ny<0 || ny>=H) {
						continue;
					}
					if(!map[ny][nx].equals(".")) {
						continue;
					}
					map[y][x]=".";
					x=nx;
					y=ny;
					map[y][x]=">";
					break;
				case 'S':
					int multi=0;
					while(true){
						multi++;
						nx=x+dx[dir]*multi;
						ny=y+dy[dir]*multi;
						if(nx<0 || nx>= W || ny<0 || ny>=H) {
							break;
						}
						if(map[ny][nx].equals("*")) {
							map[ny][nx]=".";
							break;
						}
						
						if(map[ny][nx].equals("#")) {
							break;
						}
						
					}
					break;
				}
			}
			System.out.print("#"+t+" \n");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println("");
			}

		}

	}

}

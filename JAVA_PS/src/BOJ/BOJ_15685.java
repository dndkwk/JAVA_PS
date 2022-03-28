package BOJ;
import java.util.*;
import java.io.*;

public class BOJ_15685 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;
	static boolean[][] board=new boolean[105][105];
	static int cnt=0;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for(int t=0;t<N;t++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int g=Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> dir=new ArrayList<>();
			dir.add(d%4);
			board[y][x]=true;
			while(g-->0) {
				int sz=dir.size();
				for(int i=sz-1;i>=0;i--) {
					dir.add((dir.get(i)+1)%4);
				}
			}
			
			for(int i=0;i<dir.size();i++) {
				int dd=dir.get(i);
				if(dd==0) {
					x++;
				}else if(dd==1) {
					y--;
				}else if(dd==2) {
					x--;
				}else if(dd==3) {
					y++;
				}
				board[y][x]=true;
			}
		}
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(!board[i][j]) {
					continue;
				}
				if(board[i+1][j] && board[i][j+1] && board[i+1][j+1] ) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}

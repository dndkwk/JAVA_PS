package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int R, C;
	static int cnt = 1;
	static int result = 1;
	static char[][] arr = new char[20][20];
	static boolean[] visited = new boolean[26];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void sol(int y,int x) {
		char c=arr[y][x];
		visited[c-'A']=true;
		
		for(int i=0;i<4;i++) {
			int ny=y+dy[i];
			int nx=x+dx[i];
			
			if(0<=nx && nx<C && 0<=ny && ny<R) {
				char next=arr[ny][nx];
				if(!visited[next-'A']) {
					result=Math.max(++cnt, result);
					sol(ny,nx);
				}
				
			}
			
		}
		--cnt;
		visited[c-'A']=false;
		
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}

		sol(0, 0);

		System.out.println(result);

	}

}

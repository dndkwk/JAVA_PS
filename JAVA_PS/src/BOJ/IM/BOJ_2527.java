package BOJ.IM;

import java.util.*;
import java.io.*;

public class BOJ_2527 {
	
	public static char isRectangle (int minX, int minY, int maxX, int maxY, int width1, int height1, int width2, int height2) {
		if (((width1+width2 == maxX-minX) && (height1+height2 > maxY-minY)) || ((height1+height2 == maxY-minY) && (width1+width2 > maxX-minX)))
			return 'b';
		else if ((width1+width2 == maxX-minX) && (height1+height2 == maxY-minY)) // 점이 겹치는 경우
			return 'c';
		else if ((width1+width2 < maxX-minX) || (height1+height2 < maxY-minY)) // 공통부분이 없는 경우
			return 'd';
		else
			return 'a';
	}


	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 4; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			
			int minX = Math.min(x1, x2); // 입력받은 x좌표의 최솟값
			int maxX = Math.max(p1, p2); // 입력받은 x좌표의 최댓값
			int minY = Math.min(y1, y2); // 입력받은 y좌표의 최솟값
			int maxY = Math.max(q1, q2); // 입력받은 y좌표의 최댓값
			
			int width1 = p1 - x1; // 첫번째 직사각형의 가로 길이
			int height1 = q1 - y1; // 첫번째 직사각형의 세로 길이
			int width2 = p2 - x2; // 두번째 직사각형의 가로 길이
			int height2 = q2 - y2; // 두번째 직사각형의 세로 길이
			
			System.out.println(isRectangle(minX, minY, maxX, maxY, width1, height1, width2, height2));
		}
	}
}
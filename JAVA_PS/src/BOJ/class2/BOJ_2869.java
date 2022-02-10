package BOJ.class2;

import java.io.*;
import java.util.*;

public class BOJ_2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int h = 0;
		int cnt = 1;
		cnt += (V - A) / (A - B);
		
		if((V - A) % (A - B)!=0) {
			cnt++;
		}
		
		if (A >= V) {
			System.out.println(1);
		} else {
			System.out.println(cnt);
		}

	}

}


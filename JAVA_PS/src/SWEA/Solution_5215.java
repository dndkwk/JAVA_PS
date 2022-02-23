package SWEA;

import java.io.*;
import java.util.*;

/*
 * 부분집합/ 조합,순열로 풀기엔 N이 너무 커보였다. 조합으로 하면 1개선택...20개 선택 여러가지 고려
 * =>부분집합 선택
 * 
 * */

public class Solution_5215 {

	static int N;
	static int L;
	static int result;
	static int[] taste;
	static int[] cal;
	static boolean[] check;

	static void solution(int cnt) {
		if (cnt == N) {
			int total_cal = 0;
			int total_taste = 0;
			for (int i = 0; i < N; i++) {
				if (check[i]) {
					total_cal += cal[i];
					total_taste += taste[i];
				}
			}
			if (total_cal <= L) {
				result = Math.max(total_taste, result);
			}
		} else {
			check[cnt] = true;
			solution(cnt + 1);
			check[cnt] = false;
			solution(cnt + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			result = 0;

			taste = new int[N];
			cal = new int[N];
			check = new boolean[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			solution(0);
			System.out.println("#"+t+" "+result);
		}

	}

}

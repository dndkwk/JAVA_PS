package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<String> q1 = new LinkedList<String>();
			Queue<String> q2 = new LinkedList<String>();
			for (int i = 0; i < (N + 1) / 2; i++) {
				q1.add(st.nextToken());
			}

			for (int i = 0; i < N/2; i++) {
				q2.add(st.nextToken());
			}
			System.out.print("#"+t+" ");
			while(!q2.isEmpty()) {
				System.out.print(q1.poll()+" ");
				System.out.print(q2.poll()+" ");
			}
			
			if(!q1.isEmpty()) {
				System.out.print(q1.poll()+" ");
			}
			System.out.println("");
		}

	}

}

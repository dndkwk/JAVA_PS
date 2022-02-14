package BOJ.class3;

import java.io.*;
import java.util.*;

public class BOJ_1764 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	// 고정

	static int N, M;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<String> arr=new ArrayList<>();
		ArrayList<String> answer=new ArrayList<>();
		
		int cnt=0;
		
		for (int i = 0; i < N; i++) {
			String temp=br.readLine();
			arr.add(temp);
		}
		
		
		Collections.sort(arr);
		
		for (int i = 0; i < M; i++) {
			String temp=br.readLine();
			if(Collections.binarySearch(arr, temp)>=0) {
				cnt++;
				answer.add(temp);
			}
		}
		
		Collections.sort(answer);
		sb.append(cnt+"\n");
		for(String s : answer) {
			sb.append(s+"\n");
		}
		System.out.println(sb);

		return;
	}

}

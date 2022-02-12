package BOJ.IM;

import java.io.*;
import java.util.*;

public class BOJ_2605 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr= new ArrayList<>();
		
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		arr.add(-1);
		for(int i=1;i<=N;i++) {
			arr.add(i-Integer.parseInt(st.nextToken()),i);
		}
		for(int i=1;i<=N;i++) {
			System.out.print(arr.get(i)+" ");
		}
		
		
		

	}

}

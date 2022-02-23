package SWEA;

import java.io.*;
import java.util.*;

public class Solution_1228 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int t=1;t<=10;t++) {
			int N=Integer.parseInt(br.readLine());
			LinkedList<Integer> arr= new LinkedList<>();
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			int M=Integer.parseInt(br.readLine());
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				String Ins=st.nextToken();
				int x= Integer.parseInt(st.nextToken());
				int y= Integer.parseInt(st.nextToken());
				for(int j=0;j<y;j++) {
					arr.add(x++, Integer.parseInt(st.nextToken()));
				}
			}
			System.out.print("#"+t+" ");
			for(int i=0;i<10;i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println("");
		}
	}

}

package BOJ.class2;

import java.io.*;
import java.util.*;

public class BOJ_2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int answer=0;
		for(int i=1;i<N;i++) {
			int sum=0;
			sum+=i;
			int num=i;

			while(num!=0) {
				sum+=num%10;
				num /=10;
			}
			
			if(sum==N) {
				answer=i;
				break;
			}
		}
		
		System.out.println(answer);
		
	}

}


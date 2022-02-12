package BOJ.IM;
import java.io.*;
import java.util.*;


public class BOJ_2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num=new int[9];
		int sum=0;
		int a=0,b=0;
		for(int i=0;i<9;i++) {
			num[i]=Integer.parseInt(br.readLine());
			sum+=num[i];
		}
		
		Arrays.sort(num);
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(i!=j) {
					if(sum-num[i]-num[j]==100) {
						a=i;
						b=j;
					}
				}
			}
		}
		
		for(int i=0;i<9;i++) {
			if(i==a || i==b) {
				continue;
			}
			System.out.println(num[i]);
		}
		
		

	}

}

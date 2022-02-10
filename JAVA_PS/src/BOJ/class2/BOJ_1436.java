package BOJ.class2;
import java.io.*;
import java.util.*;

public class BOJ_1436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st= new StringTokenizer(br.readLine());
		int num=666;
		int cnt=1;
		
		int N=Integer.parseInt(br.readLine());
		while(cnt !=N) {
			num++;
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(num);
		
		

	}

}

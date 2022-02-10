package BOJ.class2;
import java.io.*;
import java.util.*;

public class BOJ_11050 {
	
	static int sol(int num) {
		if(num==0)return 1;
		int result=1;
		for(int i=num;i>=1;i--) {
			result*=i;
		}
		
		return result;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		System.out.println(sol(n)/(sol(k)*sol(n-k)));
		
	}

}

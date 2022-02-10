package BOJ.class2;
import java.io.*;
import java.util.*;

public class BOJ_2775 {
	static int solution(int k,int n) {
		if(n==1) {
			return 1;
		}
		if(k==0) {
			return n;
		}
		return solution(k-1,n)+solution(k,n-1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int k=Integer.parseInt(br.readLine());
			int n=Integer.parseInt(br.readLine());
			int result=solution(k,n);
			System.out.println(result);
		}

	}

}

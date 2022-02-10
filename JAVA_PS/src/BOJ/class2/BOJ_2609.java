package BOJ.class2;
import java.io.*;
import java.util.*;

public class BOJ_2609 {

	static int GCD(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		System.out.println(GCD(N,M));
		System.out.println((N*M)/GCD(N,M));
		

	}

}


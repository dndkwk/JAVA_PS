package BOJ.class3;
import java.io.*;
import java.util.*;

public class BOJ_1003 {

	static int[] arr= new int[50];
	
	static int sol(int n){
		if(n==0 ||n==1) {
			return arr[n];
		}else if(arr[n]==0) {
			arr[n]=sol(n-1)+sol(n-2);
		}
		return arr[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st=new StringTokenizer(br.readLine());
		
		int T=Integer.parseInt(br.readLine());
		
		arr[0]=0;
		arr[1]=1;
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
			if(N==0) {
				System.out.println("1 0");
			}else {
				System.out.println(sol(N-1)+" "+sol(N));
			}
		}
		

	}

}

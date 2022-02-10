package BOJ.class2;
import java.io.*;
import java.util.*;

public class BOJ_2108 {
	static int[] arr;
	static int[] cnt = new int[8001];
	static int N, b, c, d;
	static int a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		
		//StringTokenizer st=new StringTokenizer(br.readLine());
		
		int sum=0;
		
		arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i];
			cnt[arr[i]+4000]++;
		}
		
		Arrays.sort(arr);
		
		int max=0;
		int flag=0;
		for(int i=0;i<8001;i++) {
			if(cnt[i]>max) {
				max=cnt[i];
				flag=i;
			}
			
		}
		
		for(int i=flag+1;i<8001;i++) {
			if(cnt[i]==max) {
				flag=i;
				break;
			}	
		}
		
		a =(int) Math.round((double)sum / N);
		b = arr[(N - 1) / 2];
		c = flag - 4000;
		d = arr[N - 1] - arr[0];
		
		
		System.out.println(a+"\n"+b+"\n"+c+"\n"+d);
		
	}

}

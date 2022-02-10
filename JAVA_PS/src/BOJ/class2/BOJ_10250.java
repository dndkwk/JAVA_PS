package BOJ.class2;
import java.io.*;
import java.util.*;

public class BOJ_10250 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int H=Integer.parseInt(st.nextToken());
			int W=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			
			int h=N%H;
			int w=N/H;
			if(h>0) {
				w++;
			}else {
				h=H;
			}
			System.out.println(h*100+w);
		}
		

	}

}


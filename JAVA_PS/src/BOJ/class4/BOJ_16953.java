package BOJ.class4;
import java.io.*;
import java.util.*;

public class BOJ_16953 {

	static int result=-1;
	static long A,B;
	
	static class pair{
		long n;
		int cnt;
		public pair(long n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A=Long.parseLong(st.nextToken());
		B=Long.parseLong(st.nextToken());
		Queue<pair> q=new LinkedList<pair>();
		q.add(new pair(A,0));
		while(!q.isEmpty()) {
			pair cur=q.poll();
			if(cur.n==B) {
				result=cur.cnt+1;
				break;
			}
			if(cur.n*2 <= B) {
				q.add(new pair(cur.n*2 ,cur.cnt+1));
			}
			
			if(cur.n*10+1 <= B) {
				q.add(new pair(cur.n*10+1 ,cur.cnt+1));
			}
			
		}
		
		System.out.println(result);
	}
}
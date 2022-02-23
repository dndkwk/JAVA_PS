package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		
		Queue<Integer> q=null;
		for(int t=1;t<=10;t++) {
			q=new LinkedList<>();
			int T=Integer.parseInt(br.readLine());
			StringTokenizer st= new StringTokenizer(br.readLine());
			boolean flag=false;
			int cnt=1;
			
			for(int i=0;i<8;i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			while(!flag) {
				int temp=q.poll();
				temp=temp-cnt;
				if(temp<=0) {
					flag=true;
					temp=0;
				}
				cnt=(cnt+1)%6;
				if(cnt==0) {
					cnt=1;
				}
				q.add(temp);
			}
			
			System.out.print("#"+T+" ");
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
			System.out.println("");
			
		}
		

	}

}

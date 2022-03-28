import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			pq.add(Double.parseDouble(st.nextToken()));
		}
		int k=Integer.parseInt(br.readLine());
		for(int i=0;i<k;i++) {
			Double temp=pq.poll();
			temp/=2;
			pq.add(temp);
			pq.add(temp);
		}
		double max=pq.poll();
		while(pq.size()!=1) {
			pq.poll();
		}
		double min=pq.poll();
		//System.out.println(min);
		System.out.println(max-min);
		
	}
}

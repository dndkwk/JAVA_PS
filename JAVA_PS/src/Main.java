import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	
	
	public static void main(String[] args) throws Exception {
		LinkedList<Integer> arr=new LinkedList<>();
		arr.add(3);
		arr.add(2);
		arr.add(1);
		arr.add(1);
		arr.add(1);
		Iterator<Integer> iter=arr.iterator();
		while(iter.hasNext()) {
			Integer temp=iter.next();
			if(temp==3) {
				iter.remove();
			}
			System.out.println(temp);
		}
		System.out.println(arr);
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	
	public static void main(String[] args) throws Exception {
		int[] arr= {1,2,3,3,3,3,3,3,9};
		System.out.println(Arrays.binarySearch(arr, 3));
		System.out.println(Arrays.binarySearch(arr, 4)*-1-1);
		
		
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

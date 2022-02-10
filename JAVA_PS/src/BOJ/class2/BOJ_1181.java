package BOJ.class2;
import java.io.*;
import java.util.*;

public class BOJ_1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			if (!arr.contains(temp)) {
				arr.add(temp);
			}
		}
		Collections.sort(arr, (String o1, String o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			} else {
				return o1.length() - o2.length();
			}
		});
		for (String temp : arr) {
			System.out.println(temp);
		}
	}

}

package BOJ.class2;
import java.io.*;
import java.util.*;

public class BOJ_1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		ArrayList<String> ss = new ArrayList<>();
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}

		int j = 0;

		for (int i = 1; i <= N; i++) {
			s.push(i);
			ss.add("+");
			while (!s.empty() && (s.peek().equals(arr.get(j)))) {
				s.pop();
				ss.add("-");
				j++;
			}
		}

		if (!s.empty()) {
			System.out.println("NO");
		} else {
			for (int i = 0; i < ss.size(); i++) {
				System.out.println(ss.get(i));
			}
		}

	}

}

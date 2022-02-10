package BOJ.class2;
import java.io.*;
import java.util.*;

public class BOJ_10814 {

	static class Pair {
		int age;
		String name;

		Pair(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Pair> arr=new ArrayList<>();
		
		for (int t = 0; t < N; t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			arr.add(new Pair(Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		Collections.sort(arr,(Pair p1,Pair p2)->{return p1.age-p2.age;});
		
		for(Pair p: arr) {
			System.out.println(p.age + " "+p.name);
		}
		
	}

}

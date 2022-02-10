package BOJ.class2;
import java.io.*;
import java.util.*;

public class BOJ_1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st= new StringTokenizer(br.readLine());

		while (true) {
			String temp = br.readLine();
			boolean result = true;
			if (temp.equals("0")) {
				break;
			}
			if (temp.length() % 2 == 0) {
				for (int i = 0; i < temp.length() / 2; i++) {
					if (temp.charAt(i) != temp.charAt(temp.length() - i - 1)) {
						result = false;
						break;
					}
				}
			} else {
				for (int i = 0; i < temp.length() / 2; i++) {
					if (temp.charAt(i) != temp.charAt(temp.length() - i - 1)) {
						result = false;
						break;
					}
				}
			}
			if(result) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}

	}

}

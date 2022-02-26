package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1759 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	/*  */

	static int L,C;
	static List<String> aeiou;
	static List<String>  az;
	static HashSet<String> check;
	static List<String> result;
	
	static void sol(int idx1,int idx2,int cnt1,int cnt2, String s) {
		if((cnt1+cnt2) == L) {
			if(cnt1>=1 && cnt2 >=2) { //조건 고려
				char[] ch=s.toCharArray();
				Arrays.sort(ch); // 문자열 정렬
				s=new String(ch);
				if(!check.contains(s)) { //중복체크
					check.add(s);
					result.add(s);
				}
			}
			return;
		}else {
			//모음과 자음 경우의 수 
			for(int i=idx1;i<aeiou.size();i++) {
				sol(i+1,idx2,cnt1+1,cnt2,s+aeiou.get(i));
			}
			
			for(int i=idx2;i<az.size();i++) {
				sol(idx1,i+1,cnt1,cnt2+1,s+az.get(i));
			}
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		
		st=new StringTokenizer(br.readLine());
		L=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		aeiou=new ArrayList<String>();
		az=new ArrayList<String>();
		check=new HashSet<>();
		result=new ArrayList<String>();
		String s= "aeiou";
		
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			String temp=st.nextToken();
			if(s.contains(temp)) {//모음 자음 나누기
				aeiou.add(temp);
			}else {
				az.add(temp);
			}
		}
		
		Collections.sort(aeiou);
		Collections.sort(az);
		
		sol(0,0,0,0,"");
		
		Collections.sort(result); // 정렬
		
		for(String temp: result) {
			sb.append(temp+"\n");
		}
		
		System.out.println(sb);
		
	}
}

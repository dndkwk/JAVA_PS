package SAMSUNG;

import java.util.*;
import java.io.*;

public class BOJ_17825 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	//
	static int N=10;
	static int[] dices=new int[N];
	static int[][] board;
	static pair[] horses=new pair[4];
	static pair start;
	static int ans=Integer.MIN_VALUE;
	
	static class pair{
		int val;
		boolean emp,fin;
		pair next,fast;
		
		pair(int val){
			this.val=val;
			this.emp=true;
		}
		
		pair nxt(int value) {
			pair nxtNode=new pair(value);
			this.next=nxtNode;
			return nxtNode;
		}
		
		static pair getpair(pair start,int target) {
			pair temp=start;
			while(true) {
				if(temp==null) {
					return null;
				}
				if(temp.val==target) {
					return temp;
				}
				temp=temp.next;
			}
		}
	}
	
	
	static void init() {
		start=new pair(0);
		pair temp=start;
		for(int i=2;i<=40;i+=2) {
			temp=temp.nxt(i);
		}
		
		pair end=temp.nxt(0);
		end.fin=true;
		end.next=end;
		
		pair cross=new pair(25);
		temp=cross.nxt(30);
		temp=temp.nxt(35);
		temp.next=pair.getpair(start,40);
		
		temp=pair.getpair(start, 10);
		temp=temp.fast=new pair(13);
		temp=temp.nxt(16);
		temp=temp.nxt(19);
		temp.next=cross;
		
		temp=pair.getpair(start, 20);
		temp=temp.fast=new pair(22);
		temp=temp.nxt(24);
		temp.next=cross;
		
		temp=pair.getpair(start, 30);
		temp=temp.fast=new pair(28);
		temp=temp.nxt(27);
		temp=temp.nxt(26);
		temp.next=cross;
	}

	public static void main(String[] args) throws Exception {
		init();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			dices[i]=stoi(st.nextToken());
		}
		
		for(int t=0;t<(int)Math.pow(4, 10);t++) {
			Arrays.fill(horses, start);
			int bf=t;
			int score=0;
			for(int i=0;i<10;i++) {
				int dice=bf%4;
				bf/=4;
				pair cur=horses[dice];
				cur.emp=true;
				
				for(int j=1;j<=dices[i];j++) {
					if(j==1 && cur.fast!=null) {
						cur=cur.fast;
					}else {
						cur=cur.next;
					}
				}
				
				horses[dice]=cur;
				if(!cur.emp && !cur.fin) {
					score=0;
					break;
				}else {
					cur.emp=false;
					score+=cur.val;
				}
			}
			ans=Math.max(ans, score);
			
			for(int i=0;i<4;i++) {
				horses[i].emp=true;
			}
			
		}
		
		
		System.out.println(ans);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}


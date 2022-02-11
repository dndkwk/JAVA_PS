package BOJ;

import java.io.*;
import java.util.*;

public class Main_1244 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str= br.readLine();
	    int N=Integer.parseInt(str);
	    int M=0;
	    int[] arr=new int[N+1];
	    StringTokenizer st=new StringTokenizer(br.readLine()); 
	    
	    for(int i=1;i<N+1;i++) {
	    	arr[i]=Integer.parseInt(st.nextToken());
	    }
	    
	    st=new StringTokenizer(br.readLine());
	    M=Integer.parseInt(st.nextToken());
	    
	    for(int i=0;i<M;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	
	    	if(st.nextToken().equals("1")) {//남학생
	    		int multi=Integer.parseInt(st.nextToken());
	    		for(int j=0;j<N+1;j+=multi) {
	    			if(arr[j]==0) {
	    				arr[j]=1;
	    			}else {
	    				arr[j]=0;
	    			}
	    		}
	    	}else {//여학생
	    		int pivot=Integer.parseInt(st.nextToken());
	    		for(int j=0;j<N+1;j++) {
	    			if(pivot-j<=0 || pivot+j > N) {
	    				break;
	    			}
	    			if(arr[pivot-j] == arr[pivot+j]) {
	    				if(arr[pivot-j]==0) {
		    				arr[pivot-j]=1;
		    				arr[pivot+j]=1;
		    			}else {
		    				arr[pivot-j]=0;
		    				arr[pivot+j]=0;
		    			}
	    			}else {
	    				break;
	    			}
	    		}
	    		
	    	}
	    }
	    
	    for(int i=1;i<N+1;i++) {
	    	System.out.print(arr[i]+" ");
	    	if(i%20==0) {
	    		System.out.println("");
	    	}
	    }
	    
	    
	    
	    

	}

}

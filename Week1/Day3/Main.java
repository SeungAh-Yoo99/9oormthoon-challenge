import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int result = 0;
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			String op = st.nextToken();
			int b = Integer.parseInt(st.nextToken());
			
			if(op.equals("+")) result += a + b;
			else if(op.equals("-")) result += a - b;
			else if(op.equals("*")) result += a * b;
			else result += a / b;
		}
		
		System.out.println(result);
	}
}
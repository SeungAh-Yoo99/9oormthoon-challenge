import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		double W = Double.parseDouble(st.nextToken());
		double R = Double.parseDouble(st.nextToken());
		
		System.out.println((int)(W * (1 + R / 30)));
	}
}
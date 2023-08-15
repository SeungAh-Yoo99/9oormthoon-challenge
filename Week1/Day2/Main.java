import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			// 분 더하기
			M += Integer.parseInt(br.readLine());
		}

		// 60분 넘을 경우 시간에 더해주기
		T += M / 60;
		M = M % 60;
		// 23시간 넘을 경우 빼주기
		T = T % 24;
		
		System.out.println(T + " " + M);
	}
}
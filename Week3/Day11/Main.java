import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N 입력
		int N = Integer.parseInt(br.readLine());
		
		// A, B 입력
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		// 더 큰 치료제인 B를 먼저 사용할 수 있을 만큼 사용한다고 가정
		int numB = N / B;
		
		// N이 0이 될 때까지 B의 치료제 개수를 줄이고 A의 개수를 늘려준다.
		int result = 0;
		while(numB >= 0) {
			if((N - (B * numB)) % A == 0) {
				result = ((N - (B * numB)) / A) + numB;
				break;
			}
			numB--;
		}
		
		// 통증 수치를 0으로 만들 수 없는 경우에는 -1 출력
		result = result == 0 ? -1 : result;
		
		// 출력
		System.out.println(result);
	}
}
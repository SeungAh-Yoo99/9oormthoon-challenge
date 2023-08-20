import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][2]; // arr[i][0] := 원래의 10진수 값, arr[i][1] := 2진수로 변환했을 때의 1의 개수
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int tmp = num;
			
			int n = 0; // 1의 개수
			while(tmp > 0) { // 비트 연산을 이용하여 1의 개수 세기
				if((tmp & 1) == 1) n++;
				tmp = tmp >> 1;
			}
			
			arr[i][0] = num;
			arr[i][1] = n;
		}
		
		// 정렬
		Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);
		
		// 출력
		System.out.println(arr[K - 1][0]);
	}
}
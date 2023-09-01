import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, K 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 과일 조각의 개수와 포만감을 담을 배열
		int[][] basket = new int[N][2]; // basket[i][0] := i번째 과일의 한 조각의 포만감, basket[i][1] := i번째 과일의 남은 조각 개수
		for(int i = 0; i < N; i++) {
			// 과일별 P, C 입력
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			basket[i][0] = C / P;
			basket[i][1] = P;
		}
		
		// 과일 바구니를 포만감 높은 순으로 정렬
		Arrays.sort(basket, (o1, o2) -> o2[0] - o1[0]);
		
		// 가지고 있는 돈만큼 과일 조각 구매
		long result = 0;
		for(int i = 0; i < N; i++) {
			if(basket[i][1] <= K) { // 남은 돈으로 현재 과일의 모든 조각을 살 수 있는 경우
				result += basket[i][0] * basket[i][1];
				K -= basket[i][1];
			}
			else { // 남은 돈으로 현재 과일의 모든 조각을 살 수 없는 경우
				result += basket[i][0] * K;
				break;
			}
		}
		
		// 답 출력
		System.out.println(result);
	}
}
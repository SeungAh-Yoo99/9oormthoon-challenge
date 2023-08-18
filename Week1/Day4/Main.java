import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 재료 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = arr[0]; // 답 
		boolean isForward = true; // 증가하는 중이면 true
		for(int i = 1; i < N; i++) {
			if(isForward) { // 전 재료까지 계속 증가 중이었다면
				if(arr[i - 1] > arr[i]) { // 이번에 감소하면
					isForward = false;
				}
			} else { // 전 재료가 감소 중이었다면
				if(arr[i - 1] < arr[i]) { // 다시 증가하면 안됨
					result = 0;
					break;
				}
			}
			result += arr[i]; // 이번 재료의 맛의 정도 더 해줌.
		}
		
		System.out.println(result);
	}
}
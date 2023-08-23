import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		int N = Integer.parseInt(br.readLine());
		
		int result = 0; // 총 아이템 사용 개수
		
		result += N / 14; // painkiller를 사용할 수 있을 만큼 사용
		N = N % 14; // 아이템 사용한 만큼 통증 수치 감소
		
		result += N / 7; // medicine을 사용할 수 있을 만큼 사용
		N = N % 7; // 아이템 사용한 만큼 통증 수치 감소
		
		// 나머지 모두 bandage 사용
		result += N;
		
		// 출력
		System.out.println(result);
	}
}
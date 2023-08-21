import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		TreeSet<String> ts = new TreeSet<>(); // 문자열을 중복 없이 사전 순으로 담을 자료 구조
		for(int i = 1; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				ts.add(s.substring(0, i)); // 첫 번째 부분문자열 추가
				ts.add(s.substring(i, j)); // 두 번째 부분문자열 추가
				ts.add(s.substring(j, N)); // 세 번째 부분문자열 추가
			}
		}
		
		// TreeSet에서 순서대로 꺼내며 Map에 부분문자열과 순서 저장
		Map<String, Integer> map = new HashMap<>(); // key := 부분문자열, value := 몇 번째 문자열인지
		int n = 1;
		while(!ts.isEmpty()) {
			map.put(ts.pollFirst(), n++);
		}
	
		// 답 구하기
		int result = 0;
		for(int i = 1; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					int tmp = 0;
					tmp += map.get(s.substring(0, i));
					tmp += map.get(s.substring(i, j));
					tmp += map.get(s.substring(j, N)); // 점수의 합 구하기
					result = result < tmp ? tmp : result; // 역대 최대값과 비교하여 result 갱신
				}
		}

		System.out.println(result);
	}
}
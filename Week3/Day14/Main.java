import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, M, K 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 간선 정보를 담을 리스트
		ArrayList<PriorityQueue<Integer>> list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new PriorityQueue<>());
		}
		
		// 간선 정보 입력
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list.get(s).add(e);
			list.get(e).add(s);
		}
		
		// 이동 시작
		int s = K; // 출발 노드
		int e = K; // 다음 노드
		boolean[] visited = new boolean[N + 1]; // 방문 체크 배열
		int count = 0;
		while(true) {
			visited[s] = true; // 현재 노드 방문 체크
			count++; // 방문한 노드 개수 + 1
			
			while(!list.get(s).isEmpty()) { // 다음으로 방문할 수 있는 노드가 남았을 때까지
				int tmp = list.get(s).poll(); // 다음 노드 후보
				if(!visited[tmp]) { // 아직 방문하지 않은 노드면
					e = tmp;
					break;
				}
			}
			if(e == s) { // 다음으로 방문할 노드가 없다면
				break;
			} else { // 방문할 노드가 있다면 출발 노드 바꿔줌
				s = e;
			}
		}
		
		// 출력
		System.out.println(count + " " + e);
	}
}
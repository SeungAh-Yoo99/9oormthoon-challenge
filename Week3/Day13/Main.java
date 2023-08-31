import java.io.*;
import java.util.*;

class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N과 K 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 마을 상태 입력
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 건물 유형별 단지 개수를 담을 배열
		int[] count = new int[31]; // count[i] := i 유형 건물의 단지 개수
		
		/*
		* bfs로 단지 구하기
		* 방문 했다면 0으로 바꿔 방문체크
		*/
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0) { // 아직 방문 안한 건물이라면
					
					Queue<int[]> q = new LinkedList<>();
					int c = 1; // 붙어있는 같은 유형의 건물 개수
					q.add(new int[] {i, j});
					int n = map[i][j]; // 현재 건물 유형 저장
					map[i][j] = 0; // 방문 체크
					
					while(!q.isEmpty()) {
						int[] now = q.poll();
						
						for(int k = 0; k < 4; k++) {
							int nx = now[0] + dx[k];
							int ny = now[1] + dy[k];
							
							if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
								if(map[nx][ny] == n) { // 같은 유형의 건물이라면
									map[nx][ny] = 0;
									c++;
									q.add(new int[] {nx, ny});
								}
							}
						}
					}
					
					if(c >= K) { // 단지의 기준을 넘었다면
						count[n]++; // 건물의 유행에 해당하는 단지 개수 늘려주기
					}
				}
			}
		}
		
		// 가장 많은 단지가 있는 건물 구하기
		int result = 0, c = 0;
		for(int i = 30; i > 0; i--) {
			if(c < count[i]) {
				c = count[i];
				result = i;
			}
		}
		
		// 답 출력
		System.out.println(result);
	}
}
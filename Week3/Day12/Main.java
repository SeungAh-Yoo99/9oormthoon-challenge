import java.io.*;
import java.util.*;

class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 마을의 크기 N 입력
		int N = Integer.parseInt(br.readLine());
		
		// 마을의 상태 입력
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 뭉쳐있는 1 그룹 개수 세기
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) { // 1을 발견하면 bfs로 인근의 1을 모두 2로 바꿈
					result++;
					
					// bfs
					Queue<int[]> q = new LinkedList<>();
					map[i][j] = 2; // 시작점 방문 체크
					q.add(new int[] {i, j});
					
					while(!q.isEmpty()) {
						int[] now = q.poll(); // 현재 점 꺼내기
						
						for(int k = 0; k < 4; k++) { // 현재 점에서 상하좌우가 1인지 검사
							int nx = now[0] + dx[k];
							int ny = now[1] + dy[k];
							
							if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
								if(map[nx][ny] == 1){
									map[nx][ny] = 2; // 1일 경우 2로 바꿔줌
									q.add(new int[] {nx, ny});
								}
							}
						}
					}
				}
			}
		}
		
		// 출력
		System.out.println(result);
	}
}
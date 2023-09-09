import java.io.*;
import java.util.*;

class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 배열의 크기 N, 연결 요소를 지울 기준 K, 문자를 적을 횟수 Q 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		// 배열 입력
		char[][] arr = new char[N][N];
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		// Q개의 작업 수행
		for(int i = 0; i < Q; i++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			char d = st.nextToken().toCharArray()[0];
			arr[x][y] = d;
			
			// 연결 요소 구하기(bfs 사용)
			boolean[][] visited = new boolean[N][N];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {x, y});
			visited[x][y] = true;
			int count = 1;
			
			while(!q.isEmpty()) {
				int[] now = q.poll();
				
				for(int j = 0; j < 4; j++) { // 사방 탐색
					int nx = now[0] + dx[j];
					int ny = now[1] + dy[j];
					if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
						if(arr[nx][ny] == d && !visited[nx][ny]) { // 같은 문자고 아직 방문 전이라면
							visited[nx][ny] = true;
							q.add(new int[] {nx, ny});
							count++;
						}
					}
				}
			}
			
			// 연결 요소가 K개 이상이라면
			if(count >= K) {
				// 방문했던 모든 자리 비우기
				for(int j = 0; j < N; j++) {
					for(int k = 0; k < N; k++) {
						if(visited[j][k]) arr[j][k] = '.';
					}
				}
			}
		}
		
		// 출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	static char[][] map;
	static int[][] resultMap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, K 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 땅 상태 입력
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		// 폭탄 떨어트리기
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		resultMap = new int[N][N];
		for(int i = 0; i < K; i++) {
			// x, y값 입력
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			// (x, y) 좌표와 상하좌우 폭탄값 반영
			changeMap(x, y);
			for(int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				changeMap(nx, ny);
			}
		}
			
		// 최대값 구하기
		int result = 0;
		for(int j = 0; j < N; j++) {
			for(int k = 0; k < N; k++) {
				result = result > resultMap[j][k] ? result : resultMap[j][k];
			}
		}

		System.out.println(result);
	}
	
	public static void changeMap(int x, int y) {
		// 범위 체크
		if(x < 0 || x >= N || y < 0 || y >= N) return;
		
		// 범위 안이라면 폭탄 값 반영
		if(map[x][y] == '0') { // 폭탄 값 1 증가
			resultMap[x][y]++;
		} else if(map[x][y] == '@') {
			resultMap[x][y] += 2;
		}
	}
}
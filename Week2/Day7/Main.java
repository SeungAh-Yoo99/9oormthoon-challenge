import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N과 K 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 게임판 정보 입력
		int[][] board = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// K인 깃발 개수 세기
		int result = 0;
		int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 1) continue; // 구름이 있다면 넘어가기
				int count = 0; // 주변에 구름이 몇 개 있는지
				for(int k = 0; k < 8; k++) { // 8방 탐색
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
						if(board[nx][ny] == 1) count++;
					}
				}
				if(count == K) result++; // K 깃발이라면 답 + 1
			}
		}
		
		// 답 출력
		System.out.println(result);
	}
}
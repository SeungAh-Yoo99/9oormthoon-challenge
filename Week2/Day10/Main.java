import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N 입력
		N = Integer.parseInt(br.readLine());
		
		// 구름이 시작 좌표 입력
		st = new StringTokenizer(br.readLine());
		int[] goorm = new int[2];
		goorm[0] = Integer.parseInt(st.nextToken()) - 1;
		goorm[1] = Integer.parseInt(st.nextToken()) - 1;
		
		// 플레이어 시작 좌표 입력
		st = new StringTokenizer(br.readLine());
		int[] player = new int[2];
		player[0] = Integer.parseInt(st.nextToken()) - 1;
		player[1] = Integer.parseInt(st.nextToken()) - 1;
		
		// 보드 입력
		int[][] count = new int[N][N];
		String[][] command = new String[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				String tmp = st.nextToken();
				count[i][j] = Integer.parseInt(tmp.substring(0, tmp.length() - 1));
				command[i][j] = tmp.substring(tmp.length() - 1, tmp.length());
			}
		}
		
		// 구름이 점수 구하기
		int score1 = 1;
		boolean[][] visited = new boolean[N][N];
		visited[goorm[0]][goorm[1]] = true;
	while1:	while(true) {
			int cnt = count[goorm[0]][goorm[1]];
			String cmd = command[goorm[0]][goorm[1]];
			for(int i = 0; i < cnt; i++) { // cmd 방향으로 움직일 수 있을만큼 이동
				move(goorm, cmd); // 한 칸 이동
				if(visited[goorm[0]][goorm[1]]) break while1; // 이미 방문했던 곳이라면 while문 탈출
				score1++; // 점수 올리기
				visited[goorm[0]][goorm[1]] = true; // 방문체크
			}
		}
		
		// 플레이어 점수 구하기
		int score2 = 1;
		visited = new boolean[N][N];
		visited[player[0]][player[1]] = true;
while1:		while(true) {
			int cnt = count[player[0]][player[1]];
			String cmd = command[player[0]][player[1]];
			for(int i = 0; i < cnt; i++) { // cmd 방향으로 움직일 수 있을만큼 이동
				move(player, cmd); // 한 칸 이동
				if(visited[player[0]][player[1]]) break while1; // 이미 방문했던 곳이라면 while문 탈출
				score2++; // 점수 올리기
				visited[player[0]][player[1]] = true; // 방문체크
			}
		}
		
		// 답 출력
		if(score1 > score2) System.out.println("goorm " + score1);
		else System.out.println("player " + score2);
	}
	
	private static void move(int[] p, String cmd) { // p를 cmd에 따라 한 칸씩 이동시키는 메소드
		
		if(cmd.equals("U")) { // 위
			p[0] = p[0] == 0 ? N - 1 : p[0] - 1;
		} else if(cmd.equals("D")) { // 아래
			p[0] = p[0] == N - 1 ? 0 : p[0] + 1;
		} else if(cmd.equals("R")) { // 오른쪽
			p[1] = p[1] == N - 1 ? 0 : p[1] + 1;
		} else { // 왼쪽
			p[1] = p[1] == 0 ? N - 1 : p[1] - 1;
		}
	}
}
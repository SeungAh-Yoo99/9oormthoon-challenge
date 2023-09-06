import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	static long[][][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 정사각형의 크기 N과 반직선의 개수 M 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 정사각형 정보 입력
		map = new long[N + 1][N + 1][2]; // map[i][j][0] := (i, j)의 가로선 개수, map[i][j][1] := (i, j)의 세로선 개수
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			line(x, y, d);
		}
		
		// 점 개수 구하기
		long count = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				count += map[i][j][0] * map[i][j][1];
			}
		}
		
		// 출력
		System.out.println(count);
	}
	
	static private void line(int x, int y, String d) {
		if(d.equals("U")) {
			for(int i = 1; i <= x; i++) map[i][y][1]++;
		} else if(d.equals("D")) {
			for(int i = x; i <= N; i++) map[i][y][1]++;
		} else if(d.equals("L")) {
			for(int i = 1; i <= y; i++) map[x][i][0]++;
		} else if(d.equals("R")) {
			for(int i = y; i <= N; i++) map[x][i][0]++;
		}
	}
}
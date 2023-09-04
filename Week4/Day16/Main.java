import java.io.*;
import java.util.*;

class Main {
	
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 섬의 개수 N, 다리의 개수 M 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		for(int i = 1; i <= N; i++) parent[i] = i;
		
		// s, e 입력
		boolean[][] visited = new boolean[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(visited[e][s]) { // 양방향 연결이라면
				union(s, e); // 유니온 파인드
			}
			visited[s][e] = true;
		}
		
		// union find로 조상 구하기
		for(int i = 1; i <= N; i++) find(i);
		
		//System.out.println(Arrays.toString(parent));
		
		// 연합 개수 세기
		boolean[] visited2 = new boolean[N + 1];
		int result = 0;
		for(int i = 1; i <= N; i++) {
			if(!visited2[parent[i]]) result++;
			visited2[parent[i]] = true;
		}
		
		System.out.println(result);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) return;
		
		if(a <= b) parent[b] = a;
		else parent[a] = b;
	}
	
	private static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
}
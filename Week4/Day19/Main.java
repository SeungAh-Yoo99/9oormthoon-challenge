import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 도시의 수 N, 도로의 수 M, 출발 도시 S, 도착 도시 E 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		// 도로 정보 입력
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			edges.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges.get(a).add(b);
			edges.get(b).add(a);
		}
		
		// 출발
		for(int i = 1; i <= N; i++) {
			// 출발 도시나 도착 도시가 공사 중이라면 이동이 불가능함
			if(i == S || i == E) {
				sb.append("-1\n");
				continue;
			}
			
			boolean[] visited = new boolean[N + 1];
			visited[i] = true;
			
			// bfs
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {S, 1});
			visited[S] = true; // 시작점 방문체크
			int result = -1;
			
bfsWhile:			while(!q.isEmpty()) {
				int[] now = q.poll();
				
				ArrayList<Integer> list = edges.get(now[0]);
				for(int j = 0; j < list.size(); j++) {
					int next = list.get(j);
					if(next == E) { // 도착점이라면
						result = now[1] + 1;
						break bfsWhile;
					}
					if(!visited[next]) { // 도착점은 아니지만 방문한 적 없는 도시라면
						visited[next] = true;
						q.add(new int[] {next, now[1] + 1});
					}
				}
			}
			
			sb.append(result + "\n");
		}
		
		// 답 출력
		System.out.println(sb);
	}
}
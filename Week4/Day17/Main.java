import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 컴퓨터의 개수 N과 통신 회선의 개수 M 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 간선 정보를 담을 리스트
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			edges.add(new ArrayList<>());
		}
		
		// 간선 정보 입력
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			edges.get(a).add(b);
			edges.get(b).add(a);
		}
		
		boolean[] visited = new boolean[N + 1]; // 컴퓨터 방문 체크
		
		double resultDensity = 0;
		ArrayList<Integer> resultList = new ArrayList<>(Arrays.asList(1));
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue; // 이미 방문한 컴퓨터면 다음 컴퓨터 체크하러
			
			// bfs로 연결된 컴퓨터 구하기
			ArrayList<Integer> n = new ArrayList<>(); // 이 컴포넌트를 구성하는 컴퓨터 리스트
			double e = 0; // 간선 개수
			
			visited[i] = true;
			e += edges.get(i).size();
			n.add(i);
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			
			while(!q.isEmpty()) {
				int now = q.poll();
				
				// now에 연결된 간선들 가져오기
				ArrayList<Integer> list = edges.get(now);
				for(int j = 0; j < list.size(); j++) {
					if(!visited[list.get(j)]) { // 아직 방문하지 않은 컴퓨터가 연결되어 있다면
						int cpt = list.get(j);
						visited[cpt] = true;
						e += edges.get(cpt).size();
						n.add(cpt);
						q.add(cpt);
					}
				}
			}
			
			Collections.sort(n);
			e /= 2;
			if(resultDensity == e / (double)n.size()) { // result와 밀도가 같다면
				if(resultList.size() == n.size()) { // 컴퓨터의 수가 같다면
					if(resultList.get(0) > n.get(0)) { // 더 작은 번호를 가진 컴퓨터가 있는 컴포넌트 출력
						resultList = n;
					}
				}
				else if(resultList.size() > n.size()) { // 컴퓨터의 수가 가장 작은 컴포넌트 저장
					resultList = n;
				}
			}
			else if(resultDensity < e / (double)n.size()) { // result보다 밀도가 높다면 현재의 컴포넌트 저장
				resultDensity = e / (double)n.size();
				resultList = n;
			}
		}
		
		// 답 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < resultList.size(); i++) {
			sb.append(resultList.get(i) + " ");
		}
		System.out.println(sb);
	}
}
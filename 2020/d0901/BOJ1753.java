package d0901;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단경로
// 정점수가 많음 => 인접행렬 X, 인접리스트로 구현
public class BOJ1753 {

	public static void main(String[] args) throws IOException {

		// 입력, 초기화, 할당
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken().trim());
		int E = Integer.parseInt(st.nextToken().trim());
		int start = Integer.parseInt(br.readLine());

		List<Node>[] map = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			map[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken().trim());
			int to = Integer.parseInt(st.nextToken().trim());
			int weight = Integer.parseInt(st.nextToken().trim());
			map[from].add(new Node(to, weight));
		}

		final int INF = 987654321;
		int[] distance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		Arrays.fill(distance, 1, V + 1, INF);
		distance[start] = 0;

		// start dijkstra
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.offer(new Node(start, distance[start]));

		while (!q.isEmpty()) {
			Node temp = q.poll();

			if (visited[temp.vertex]) // 선택정점 방문처리
				continue;
			visited[temp.vertex] = true;

			if (temp.distance == INF) // 완전 분리 된 상태일경우 답 X
				break;

			for (Node node : map[temp.vertex]) {
				if (!visited[node.vertex] && node.vertex != 0
						&& distance[node.vertex] > distance[temp.vertex] + node.distance) {
					distance[node.vertex] = distance[temp.vertex] + node.distance;
					q.offer(new Node(node.vertex, distance[node.vertex]));
				}
			}
		}

		// 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i <= V; i++) {
			if (distance[i] != INF)
				bw.write(String.valueOf(distance[i]) + "\n");
			else
				bw.write("INF\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static class Node implements Comparable<Node> {
		int vertex;
		int distance;

		public Node(int index, int distance) {
			this.vertex = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}

}

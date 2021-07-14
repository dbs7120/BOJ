package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 2021-07-14
// 특정한 최단 경로
// Dijkstra
// 특정점 구할때 반대도 고려하기 (s->v1->v2->e or s->v2->v1->e)
public class BOJ1504 {
	static int N, E, point1, point2, dist[], result;
	static final int INF = 987654321;
	static boolean visited[];
	static ArrayList<Node>[] map;

	static class Node implements Comparable<Node> {
		int vertex, weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		map = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			map[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[from].add(new Node(to, weight));
			map[to].add(new Node(from, weight));
		}
		st = new StringTokenizer(br.readLine());
		point1 = Integer.parseInt(st.nextToken());
		point2 = Integer.parseInt(st.nextToken());

		// ======================================================//

		result = INF;

		int p1_p2 = dijk(point1, point2);
		int p2_p1 = dijk(point2, point1);
		int s_p1 = dijk(1, point1);
		int s_p2 = dijk(1, point2);
		int p1_n = dijk(point1, N);
		int p2_n = dijk(point2, N);

		result = Math.min(result, s_p1 + p1_p2 + p2_n);
		result = Math.min(result, s_p2 + p2_p1 + p1_n);
		if (result == INF || p1_p2 == INF || p2_p1 == INF)
			result = -1;

		bw.append(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

	private static int dijk(int start, int end) {

		visited = new boolean[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, dist[start]));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (visited[cur.vertex])
				continue;
			visited[cur.vertex] = true;

			for (Node node : map[cur.vertex]) {
				if (!visited[node.vertex] && node.weight != 0 && dist[node.vertex] > dist[cur.vertex] + node.weight) {
					dist[node.vertex] = dist[cur.vertex] + node.weight;
					pq.offer(new Node(node.vertex, dist[node.vertex]));
				}

			}

		}

		if (dist[end] != INF)
			return dist[end];

		return INF;
	}

}

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

// 2021-07-16
// 파티
public class BOJ1238 {
	static int N, M, X, dist[], length[], result;
	static final int INF = 987654321;
	static boolean visited[];

	static class Node implements Comparable<Node> {
		int vertex, weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static ArrayList<Node> map[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new ArrayList[N + 1];
		length = new int[N + 1];
		result = 0;

		for (int i = 0; i < N + 1; i++) {
			map[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[from].add(new Node(end, weight));
		}

		for (int i = 1; i <= N; i++) {
			length[i] += dijk(i, X);
			length[i] += dijk(X, i);
			result = Math.max(result, length[i]);
		}

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
				if (!visited[node.vertex] && node.vertex != 0 && dist[node.vertex] > dist[cur.vertex] + node.weight) {
					dist[node.vertex] = dist[cur.vertex] + node.weight;
					pq.offer(new Node(node.vertex, dist[node.vertex]));

				}
			}

		}

		return dist[end];
	}

}

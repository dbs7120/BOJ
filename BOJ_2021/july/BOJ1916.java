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
// 최소비용 구하기
// Dijkstra
public class BOJ1916 {

	static int N, M, dist[], start, end;
	static boolean visited[];
	static final int INF = 987654321;

	static ArrayList<Node>[] map;

	static class Node implements Comparable<Node> {
		int vertex, weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		map = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			map[i] = new ArrayList<Node>();
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[from].add(new Node(to, weight));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];
		visited = new boolean[N + 1];

		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, dist[start]));

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

//		for (ArrayList<Node> e : map) {
//			System.out.println(e.toString());
//		}
//
//		System.out.println(Arrays.toString(dist));

		bw.append(dist[end] + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}

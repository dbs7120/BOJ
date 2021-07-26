package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 2021-07-26
// 녹색 옷 입은 애가 젤다지?
public class BOJ4485 {
	static int N, map[][], dist[][];
	static final int INF = 987654321;

	static class Node implements Comparable<Node> {
		int y, x, weight;

		public Node(int start, int end, int weight) {
			this.y = start;
			this.x = end;
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
		int t = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			StringTokenizer st;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bw.append("Problem " + t++ + ": " + dijk(0, N - 1) + "\n");

		}
		bw.flush();
		bw.close();
		br.close();

	}

	private static int dijk(int start, int end) {
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], INF);
		}
		int dy[] = { -1, 1, 0, 0 };
		int dx[] = { 0, 0, -1, 1 };

		dist[0][0] = map[0][0];

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(0, 0, dist[0][0]));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;
				if (dist[ny][nx] > dist[cur.y][cur.x] + map[ny][nx]) {
					dist[ny][nx] = dist[cur.y][cur.x] + map[ny][nx];
					pq.add(new Node(ny, nx, dist[ny][nx]));
				}

			}

		}
		return dist[end][end];

	}

}

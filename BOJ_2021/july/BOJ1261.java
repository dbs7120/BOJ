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
// 알고스팟
public class BOJ1261 {

	static int N, M, map[][], dist[][];
	static final int INF = 987654321, dy[] = { -1, 1, 0, 0 }, dx[] = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int y, x, weight;

		public Node(int y, int x, int weight) {
			this.y = y;
			this.x = x;
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
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
			Arrays.fill(dist[i], INF);
		}

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(0, 0, 0));
		dist[0][0] = map[0][0];

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;
				if (dist[ny][nx] > dist[cur.y][cur.x] + map[ny][nx]) {
					dist[ny][nx] = dist[cur.y][cur.x] + map[ny][nx];
					pq.offer(new Node(ny, nx, map[ny][nx]));
				}
			}
		}
		bw.append(dist[N - 1][M - 1] + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}

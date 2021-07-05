package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2021-07-05
// 유기농배추
// BFS 풀이
public class BOJ1012 {
	static int N, M, K, result;
	static boolean map[][], visited[][];
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new boolean[N][M];
			visited = new boolean[N][M];
			result = 0;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] && !visited[i][j]) {
						BFS(i, j);
						result++;
					}
				}
			}

			bw.append(result + "\n");

		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void BFS(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i, j));
		visited[i][j] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = dy[d] + cur.y;
				int nx = dx[d] + cur.x;

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || !map[ny][nx] || visited[ny][nx])
					continue;
				q.offer(new Point(ny, nx));
				visited[ny][nx] = true;

			}

		}

	}

}

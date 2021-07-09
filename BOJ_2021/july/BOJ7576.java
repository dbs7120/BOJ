package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2021-07-09
// 토마토
public class BOJ7576 {
	static int M, N, map[][], result;
	static boolean visited[][], isComplete;
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

	static class Point {
		int y, x, day;

		public Point(int y, int x, int day) {
			this.y = y;
			this.x = x;
			this.day = day;
		}

	}

	static Queue<Point> q = new LinkedList<Point>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		result = 0;
		isComplete = true;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					q.offer(new Point(i, j, 0)); // 토마토이면 Queue에 다 넣어버리기
			}
		}

		BFS();

		loop: for (int[] e : map) {
			for (int f : e) {
				if (f == 0) {
					isComplete = false;
					break loop;
				}
			}
		}

		bw.append((isComplete ? result : "-1") + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

	private static void BFS() {
		while (!q.isEmpty()) {
			Point cur = q.poll();
			result = Math.max(result, cur.day);

			for (int d = 0; d < 4; d++) {
				int ny = dy[d] + cur.y;
				int nx = dx[d] + cur.x;

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || map[ny][nx] != 0)
					continue;

				map[ny][nx] = 1;
				visited[ny][nx] = true;
				q.offer(new Point(ny, nx, cur.day + 1));
			}

		}

	}
}

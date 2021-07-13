package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2021-07-13
// 벽 부수고 이동하기
public class BOJ2206 {

	static int N, M, map[][], result;

	static boolean visited[][][];
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

	static class Point {
		int y, x, bomb, length;

		public Point(int y, int x, int bomb, int length) {
			super();
			this.y = y;
			this.x = x;
			this.bomb = bomb;
			this.length = length;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M][2]; // 가로, 세로, 벽부수기 미사용/사용

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		result = BFS();
		result = result == Integer.MAX_VALUE ? -1 : result + 1;
		bw.append(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

	private static int BFS() {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(0, 0, 1, 0));
		visited[0][0][0] = true;
		int length = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (cur.y == N - 1 && cur.x == M - 1) {
				if (length > cur.length) {
					length = cur.length;
				}
			}

			for (int d = 0; d < 4; d++) {
				int ny = dy[d] + cur.y;
				int nx = dx[d] + cur.x;

				if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;

				if (map[ny][nx] == '1') {
					if (cur.bomb == 1 && !visited[ny][nx][1]) {
						visited[ny][nx][1] = true;
						q.offer(new Point(ny, nx, 0, cur.length + 1));
					}
				} else {
					if (!visited[ny][nx][cur.bomb]) {
						visited[ny][nx][cur.bomb] = true;
						q.offer(new Point(ny, nx, cur.bomb, cur.length + 1));

					}
				}

			}

		}
		return length;

	}
}

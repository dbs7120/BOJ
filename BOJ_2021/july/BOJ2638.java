package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2021-07-12
// 치즈
// BFS 풀이
public class BOJ2638 {
	static int N, M, map[][], count, time;
	static boolean visited[][];
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		time = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());

		}

		while (true) {
			count = 0;
			visited = new boolean[N][M];
			time++;

			BFS(); // map이 2값일 경우 외부공기

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int out = 0;
					for (int d = 0; d < 4; d++) {
						int ny = dy[d] + i;
						int nx = dx[d] + j;
						if (ny < 0 || nx < 0 || ny >= N || nx >= M)
							break;
						if (map[ny][nx] == 2)
							out++;
					}
					if (out >= 2 && map[i][j] == 1) {
						map[i][j] = 0;
						count++;
					}
				}
			}

			if (count == 0)
				break;
		}
		bw.append((time - 1) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

	private static void BFS() {
		Queue<Point> q = new LinkedList<Point>();

		visited[0][0] = true;
		map[0][0] = 2; // 항상 가장자리는 공백이므로 초기 시작값 2로
		q.offer(new Point(0, 0));

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = dy[d] + cur.y;
				int nx = dx[d] + cur.x;
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || map[ny][nx] == 1)
					continue;
				q.offer(new Point(ny, nx));
				map[ny][nx] = 2;

				visited[ny][nx] = true;

			}
		}

	}
}

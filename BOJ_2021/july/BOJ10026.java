package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// 2021-07-05
// 적록색약
public class BOJ10026 {

	static int N, normal, color_blindness;
	static char map1[][], map2[][];
	static boolean visited1[][], visited2[][];
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		map1 = new char[N][N];
		map2 = new char[N][N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		normal = color_blindness = 0;

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map1[i][j] = line.charAt(j);
				map2[i][j] = (map1[i][j] == 'B' ? 'B' : 'R');
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited1[i][j]) {
					BFS1(i, j);
					normal++;
				}
				if (!visited2[i][j]) {
					BFS2(i, j);
					color_blindness++;
				}

			}
		}
		bw.append(normal + " " + color_blindness + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

	private static void BFS1(int i, int j) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(i, j));
		visited1[i][j] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = dy[d] + cur.y;
				int nx = dx[d] + cur.x;

				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;
				if (visited1[ny][nx] || map1[ny][nx] != map1[i][j])
					continue;

				visited1[ny][nx] = true;
				q.offer(new Point(ny, nx));
			}
		}

	}

	private static void BFS2(int i, int j) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(i, j));
		visited2[i][j] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = dy[d] + cur.y;
				int nx = dx[d] + cur.x;

				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;
				if (visited2[ny][nx] || map2[ny][nx] != map2[i][j])
					continue;

				visited2[ny][nx] = true;
				q.offer(new Point(ny, nx));
			}
		}
	}

}

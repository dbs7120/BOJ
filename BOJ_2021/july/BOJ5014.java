package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2021-07-30
// 스타트링크
public class BOJ5014 {
	static int F, S, G, U, D, result;
	static boolean visited[];

	static class Point {
		int floor, cnt;

		public Point(int floor, int cnt) {
			this.floor = floor;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		visited = new boolean[F + 1];
		result = Integer.MAX_VALUE;

		BFS(S);

		if (result == Integer.MAX_VALUE)
			bw.append("use the stairs\n");
		else
			bw.append(result + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

	private static void BFS(int start) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(start, 0));
		visited[start] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.floor == G)
				result = Math.min(result, cur.cnt);

			int up = cur.floor + U;
			int down = cur.floor - D;

			if (up <= F && !visited[up]) {
				visited[up] = true;
				q.offer(new Point(up, cur.cnt + 1));
			}

			if (down >= 1 && !visited[down]) {
				visited[down] = true;
				q.offer(new Point(down, cur.cnt + 1));
			}
		}

	}

}

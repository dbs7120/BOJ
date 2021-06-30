package jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2021-06-30
// 숨바꼭질
// 재풀이
/**
 * 범위 조심 하기
 */
public class BOJ1697 {
	static int N, K;
	static boolean visited[];

	static class Point {
		int position, time;

		public Point(int position, int time) {
			this.position = position;
			this.time = time;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100_001];

		bw.append(BFS() + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

	private static int BFS() {
		int second = Integer.MAX_VALUE;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(N, 0));
		visited[N] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.position == K) {
				second = Math.min(second, cur.time);
			}
			if (cur.position - 1 >= 0 && !visited[cur.position - 1]) {
				visited[cur.position - 1] = true;
				q.offer(new Point(cur.position - 1, cur.time + 1));
			}
			if (cur.position + 1 <= 100000 && !visited[cur.position + 1]) {
				visited[cur.position + 1] = true;
				q.offer(new Point(cur.position + 1, cur.time + 1));
			}
			if (cur.position * 2 <= 100000 && !visited[cur.position * 2]) {
				visited[cur.position * 2] = true;
				q.offer(new Point(cur.position * 2, cur.time + 1));
			}

		}

		return second;
	}
}

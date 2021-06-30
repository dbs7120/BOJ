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
// 숨바꼭질 2
/**
 * 숨바꼭질 1 + 방법수 구하기
 */
public class BOJ12851 {
	static int N, K, way;
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
		way = 0;
		visited = new boolean[100_001];

		bw.append(BFS() + "\n");
		bw.append(way + "\n");

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
			visited[cur.position] = true; // 꺼낼때 방문체크를 해야 추가적으로 도달하는 경우 판단함

			if (cur.position == K) {
				if (second > cur.time) { // 최초로 도달
					second = cur.time;
					way = 1;
				} else if (second == cur.time) // 최초 이후 도달
					way++;
			}

			if (cur.position - 1 >= 0 && !visited[cur.position - 1]) {
				q.offer(new Point(cur.position - 1, cur.time + 1));
			}

			if (cur.position + 1 <= 100000 && !visited[cur.position + 1]) {
				q.offer(new Point(cur.position + 1, cur.time + 1));
			}

			if (cur.position * 2 <= 100000 && !visited[cur.position * 2]) {
				q.offer(new Point(cur.position * 2, cur.time + 1));
			}

		}

		return second;
	}
}

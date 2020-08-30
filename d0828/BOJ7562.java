package d0828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트의 이동
public class BOJ7562 {

	static class Loc {
		int y;
		int x;
		int count;

		public Loc(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.count = cnt;
		}
	}

	static int I;
	static int result;
	static Loc start;
	static Loc end;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			I = Integer.parseInt(br.readLine());

			result = 0;
			visit = new boolean[I][I];
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			st = new StringTokenizer(br.readLine());
			end = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

			BFS();

			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
	}

	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void BFS() {
		Queue<Loc> q = new LinkedList<Loc>();
		q.offer(start);
		visit[start.y][start.x] = true;

		while (!q.isEmpty()) {
			Loc temp = q.poll();

			if (temp.y == end.y && temp.x == end.x) {
				result = temp.count;
				return;
			}

			for (int d = 0; d < 8; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= I || nx >= I)
					continue;
				if (visit[ny][nx])
					continue;

				visit[ny][nx] = true;
				q.offer(new Loc(ny, nx, temp.count + 1));
			}
		}
	}
}

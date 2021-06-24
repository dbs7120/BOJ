package d0830;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 보물섬
public class BOJ2589 {

	static int N, M;
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] visited;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
			}
		}

		BFS();
		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}

	public static void BFS() {

		Queue<Loc> q = new LinkedList<Loc>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited = new boolean[N][M];

				if (map[i][j] == 'W')
					continue;

				q.offer(new Loc(i, j, 0));
				visited[i][j] = true;

				while (!q.isEmpty()) {
					Loc cur = q.poll();

					result = Math.max(result, cur.count); // 거리가 최대가 되게끔 갱신

					for (int d = 0; d < 4; d++) {
						int ny = cur.y + dy[d];
						int nx = cur.x + dx[d];

						if (ny < 0 || nx < 0 || ny >= N || nx >= M)
							continue;

						if (visited[ny][nx] || map[ny][nx] == 'W')
							continue;

						q.offer(new Loc(ny, nx, cur.count + 1));
						visited[ny][nx] = true;
					}
				}
			}
		}
	}

	static class Loc {
		int y;
		int x;
		int count;

		public Loc(int y, int x, int count) {
			super();
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
}

package d0830;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로탐색
public class BOJ2178 {

	static class Loc {
		int y;
		int x;
		int cnt;

		public Loc(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

	}

	static int N, M;
	static char[][] map; // 1: 빈칸 , 0: 벽
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];

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
		br.close();

	}

	public static void BFS() {
		Queue<Loc> q = new LinkedList<Loc>();
		q.offer(new Loc(0, 0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Loc cur = q.poll();

			if (cur.y == N - 1 && cur.x == M - 1) {
				result = cur.cnt + 1;
				return;
			}

			for (int d = 0; d < 4; d++) {

				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;

				if (visited[ny][nx] || map[ny][nx] == '0')
					continue;

				visited[ny][nx] = true;
				q.offer(new Loc(ny, nx, cur.cnt + 1));
			}
		}
	}
}

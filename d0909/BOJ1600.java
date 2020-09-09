package d0909;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600 {
	static class Loc {
		int y;
		int x;
		int cnt;
		int num; // 나이트이동가능수

		public Loc(int y, int x, int cnt, int num) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.num = num;
		}
	}

	static int K, W, H, map[][];
	static boolean visited[][][];

	static int dyK[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int dxK[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static int result = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		K = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		BFS();
		bw.write(result + "\n");
		bw.flush();
		bw.close();

	}

	public static void BFS() {
		Queue<Loc> q = new LinkedList<Loc>();
		q.offer(new Loc(0, 0, 0, 0));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Loc cur = q.poll();
			if (cur.y == H - 1 && cur.x == W - 1) {
				result = cur.cnt;
				return;
			}

			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= H || nx >= W)
					continue;
				if (visited[ny][nx][cur.num] || map[ny][nx] == 1)
					continue;
				q.offer(new Loc(ny, nx, cur.cnt + 1, cur.num));
				visited[ny][nx][cur.num] = true;
			}

			if (cur.num < K) {
				for (int d = 0; d < 8; d++) {
					int ny = cur.y + dyK[d];
					int nx = cur.x + dxK[d];
					if (ny < 0 || nx < 0 || ny >= H || nx >= W)
						continue;
					if (visited[ny][nx][cur.num + 1] || map[ny][nx] == 1)
						continue;
					q.offer(new Loc(ny, nx, cur.cnt + 1, cur.num + 1));
					visited[ny][nx][cur.num + 1] = true;
				}
			}

		}
	}
}
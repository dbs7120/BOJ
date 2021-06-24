package d0917;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 점프왕 쩰리(Large 및 Small, DFS&BFS)
public class BOJ16174 {

	static int N;
	static int[][] map;
	static int[] dy = { 0, 1 }; // 우 하
	static int[] dx = { 1, 0 };
	static boolean[][] visited;
	static boolean check = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0, 0);
		// BFS();
		if (check) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}

	}

	public static void DFS(int y, int x) {
		if (y == N - 1 && x == N - 1) {
			check = true;
			return;
		}

		for (int d = 0; d < 2; d++) {
			int ny = y + dy[d] * map[y][x];
			int nx = x + dx[d] * map[y][x];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
				continue;
			}
			if (visited[ny][nx])
				continue;
			visited[ny][nx] = true;
			DFS(ny, nx);
			// visited[ny][nx] = false; // 백트래킹 X (방향이 우하이기때문)
		}

	}

	public static void BFS() {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(0, 0));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			int y = cur.x;
			int x = cur.y;
			if (y == N - 1 && x == N - 1) {
				check = true;
				return;
			}
			for (int d = 0; d < 2; d++) {
				int ny = y + dy[d] * map[y][x];
				int nx = x + dx[d] * map[y][x];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
					continue;
				}
				if (visited[ny][nx])
					continue;
				q.offer(new Point(ny, nx));
				visited[ny][nx] = true;
			}
		}

	}

}

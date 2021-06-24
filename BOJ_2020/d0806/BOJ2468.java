package d0806;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 들어온높이값 중 더 큰 높이의 비가 온다면 이후는 0
// 최소한 하나의 안전영역
// 가장 낮은 영역~가장 큰 영역 BFS

class Location { // 위치 좌표
	int y;
	int x;

	public Location(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class BOJ2468 {

	static int[][] map;
	static boolean[][] visited;

	static int[] dy = { -1, 1, 0, 0 }; // 4 방위 y
	static int[] dx = { 0, 0, -1, 1 }; // 4 방위 x
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 입력 가로칸

		map = new int[N][N];

		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (minVal > map[i][j])
					minVal = map[i][j];

				if (maxVal < map[i][j])
					maxVal = map[i][j];
			}
		}

		int ans = 1;
		for (int h = minVal; h < maxVal; h++) {
			visited = new boolean[N][N];

			int safeH = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > h) {
						bfs(i, j, h);
						safeH++;
					}

				}
			}
			if (ans < safeH)
				ans = safeH;
		}
		System.out.println(ans);

		sc.close();

	}

	private static void bfs(int startY, int startX, int height) {

		Queue<Location> q = new LinkedList<Location>();

		if (map[startY][startX] > height) {
			q.offer(new Location(startY, startX));
			visited[startY][startX] = true;
			while (!q.isEmpty()) {
				Location temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = temp.y + dy[d];
					int nx = temp.x + dx[d];
					if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
						continue;
					}
					if (visited[ny][nx])
						continue;
					if (map[ny][nx] > height) {
						q.offer(new Location(ny, nx));
						visited[ny][nx] = true;
					}

				}
			}
		}

	}

}

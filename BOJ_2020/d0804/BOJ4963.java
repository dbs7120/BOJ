package d0804;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//섬의 개수
class Location { // 위치 좌표
	int y;
	int x;

	public Location(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class BOJ4963 {

	static int[][] map;
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 8 방위 y
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 }; // 8 방위 x
	static int count = 0;
	static int h, w;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {

			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0)
				break;

			count = 0;
			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					bfs(i, j);
				}

			}
			System.out.println(count);

		}

		sc.close();

	}

	static void bfs(int curY, int curX) { // BFS, visited 대신 map에 직접 바꿈
		Queue<Location> q = new LinkedList<Location>();

		if (map[curY][curX] == 1) {
			q.offer(new Location(curY, curX));
			map[curY][curX] = 0;

			while (!q.isEmpty()) {
				Location temp = new Location(q.peek().y, q.peek().x); // 현재 피크값을 임시로 넣어 주위 판단
				q.poll();
				for (int d = 0; d < 8; d++) { // 8방위 탐색하기
					int ny = temp.y + dy[d];
					int nx = temp.x + dx[d];
					if (ny < 0 || nx < 0 || ny >= h || nx >= w) { // 경계체크
						continue;
					}
					if (map[ny][nx] == 1) { // 주위 1이면 0으로 바꾸고 Queue에 넣기
						q.offer(new Location(ny, nx));
						map[ny][nx] = 0;
					}

				}

			}
			count++; // Queue값이 모두 빠진다면 섬하나 찾음

		}

	}

}

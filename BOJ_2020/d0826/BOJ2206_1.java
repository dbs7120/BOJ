package d0826;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 벽부수고 이동하기(수정)
public class BOJ2206_1 {

	static class Loc {
		int y;
		int x;
		int remove;
		int cnt;

		public Loc(int y, int x, int remove, int cnt) {
			this.y = y;
			this.x = x;
			this.remove = remove;
			this.cnt = cnt;
		}
	}

	static int N, M;
	static int[][] map;
	static int[] dy = { 0, 1, -1, 0 };
	static int[] dx = { 1, 0, 0, -1 };
	static boolean[][][] visit;
	static int result = 0;
	static boolean complete;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		// 1,1<=map<=N,M
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1][2]; // K최대 2개
		for (int i = 1; i <= N; i++) {
			String temp = sc.next();
			for (int j = 1; j <= M; j++) {
				map[i][j] = temp.charAt(j - 1) - '0';
			}
		}
		BFS();

		if (complete)
			System.out.println(result + 1);
		else
			System.out.println(-1);

		sc.close();
	}

	public static void BFS() {
		Loc start = new Loc(1, 1, 0, 0); // 시작 상태 : 좌표 y:0,x:0,벽부숨횟수:0,이동거리:0
		Queue<Loc> q = new LinkedList<Loc>();
		q.offer(start);

		int startY = start.y;
		int startX = start.x;
		visit[startY][startX][0] = true;

		while (!q.isEmpty()) {

			Loc temp = q.poll();

			if (temp.y == N && temp.x == M) {
				complete = true;
				result = temp.cnt;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int ny = dy[d] + temp.y;
				int nx = dx[d] + temp.x;
				if (ny < 1 || nx < 1 || ny >= N + 1 || nx >= M + 1)
					continue;

				if (map[ny][nx] == 1) {
					if (temp.remove == 0 && !visit[ny][nx][1]) {
						visit[ny][nx][1] = true;
						q.offer(new Loc(ny, nx, 1, temp.cnt + 1));
					}
				} else {
					if (!visit[ny][nx][temp.remove]) {
						visit[ny][nx][temp.remove] = true;
						q.offer(new Loc(ny, nx, temp.remove, temp.cnt + 1));
					}
				}

			}

		}

	}

}

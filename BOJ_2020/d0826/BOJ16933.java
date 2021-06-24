package d0826;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 벽부수고 이동하기3
// 낮밤 조건 추가
public class BOJ16933 {

	static class Loc {
		int y;
		int x;
		int remove;
		int cnt;
		boolean day;// false: 밤 / true: 낮

		public Loc(int y, int x, int remove, int cnt, boolean day) {
			this.y = y;
			this.x = x;
			this.remove = remove;
			this.cnt = cnt;
			this.day = day;
		}
	}

	static int N, M, K;
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
		K = sc.nextInt();
		// 1,1<=map<=N,M
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1][11];
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
		Loc start = new Loc(1, 1, 0, 0, true); // 시작 상태 : 좌표 y:0,x:0,벽부숨횟수:0,이동거리:0,낮
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

				if (map[ny][nx] == 0) {
					if (!visit[ny][nx][temp.remove]) { // 방문 X일때
						visit[ny][nx][temp.remove] = true;
						if (temp.day) { // 낮일경우
							q.offer(new Loc(ny, nx, temp.remove, temp.cnt + 1, false)); // 밤낮 반전
						} else
							q.offer(new Loc(ny, nx, temp.remove, temp.cnt + 1, true)); // 밤낮 반전
					}

				} else if (map[ny][nx] == 1) {
					if(temp.remove != K) {
						if (!visit[ny][nx][temp.remove + 1]) {
							if (temp.day) { // 벽부순횟수 K넘지않으면, 낮일경우
								visit[ny][nx][temp.remove + 1] = true;
								q.offer(new Loc(ny, nx, temp.remove + 1, temp.cnt + 1, false));

							} else if (!temp.day) { // 벽부순횟수 K넘지않으면, 밤일경우
								// visit[ny][nx][temp.remove + 1] = true; // 대기해야하기때문에 방문 체크 X
								q.offer(new Loc(temp.y, temp.x, temp.remove, temp.cnt + 1, true)); // 제자리위치 대기해야함(현재위치값에거리증가, 밤낮반전값 큐에 넣기)
							}
						}
					}

				}
			}
		}
	}
}

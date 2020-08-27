package d0826;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 불
public class BOJ4179 {

	static int R, C;
	static char[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();

		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String temp = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);

			}
		}

		int result = BFS();
		if (result >= 0) {
			System.out.println(result + 1);
		} else {
			System.out.println("IMPOSSIBLE");
		}

		sc.close();

	}

	public static int BFS() { // 큐두개사용
		Queue<Loc> fireQ = new LinkedList<Loc>();
		Queue<Loc> humanQ = new LinkedList<Loc>();

		// 초기 데이터 검사(불, 사람 위치파악)
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'F') {
					fireQ.offer(new Loc(i, j));
				}
				if (map[i][j] == 'J') {
					if (i == 0 || j == 0 || i == R - 1 || j == C - 1) { // 처음부터 끝단에 있는경우 바로 탈출
						return 0;
					}
					humanQ.offer(new Loc(i, j));
				}
			}
		}

		int result = 0;

		while (!fireQ.isEmpty() || !humanQ.isEmpty()) {

			int fireSize = fireQ.size();
			for (int i = 0; i < fireSize; i++) { // fireQ 먼저 처리하여 처음의 불갯수만큼 불 퍼트려 놓기
				Loc fire = fireQ.poll();
				for (int d = 0; d < 4; d++) {
					int fy = fire.y + dy[d];
					int fx = fire.x + dx[d];

					if (fy < 0 || fx < 0 || fy >= R || fx >= C || map[fy][fx] != '.') // 경계초과, 빈칸아닐때 거름
						continue;

					map[fy][fx] = 'F';
					fireQ.offer(new Loc(fy, fx));
				}
			}

			int humanSize = humanQ.size();
			for (int i = 0; i < humanSize; i++) {
				Loc man = humanQ.poll();
				if (man.y == 0 || man.x == 0 || man.y == R - 1 || man.x == C - 1) { // 성공조건 (맵의 양끝단 도달성공)
					return result;
				}
				for (int d = 0; d < 4; d++) {
					int ny = man.y + dy[d];
					int nx = man.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] != '.') // 경계초과, 빈칸아닐때 거름
						continue;

					if (!visit[ny][nx]) {
						visit[ny][nx] = true;
						humanQ.offer(new Loc(ny, nx));
					}
				}
			}
			result++;
		}
		return -1; // 실패

	}

	static class Loc {
		int y;
		int x;

		public Loc(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

}

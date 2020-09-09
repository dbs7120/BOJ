package d0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17144 {

	static int R, C, T; // 행,열,시간(초)
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 }; // 확산방향
	static int[][] map; // 입력 맵
	static boolean[][] visited;
	static int air1 = 0, air2 = 0; // 공기청정기 행위치값

	// -1 : 공기청정기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					if (air1 == 0)
						air1 = i;
					else if (air2 == 0)
						air2 = i;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			spread();
			air();
		}

		int sum = 0;
		for (int[] e : map) {
			for (int f : e) {
				// System.out.print(f + " ");
				sum += f;
			}
			// System.out.println();
		}
		System.out.println(sum + 2); // 공기청정기 위치 -1 이므로 2더해줌

	}

	private static void air() {
		// 상단부 공기청정기: 반시계

		// 공기 바람 기준

		// 하 -> 상
		for (int y = air1 - 1; y > 0; y--) {
			map[y][0] = map[y - 1][0]; // x축 고정
		}
		// 좌 -> 우
		for (int x = 0; x < C - 1; x++) {
			map[0][x] = map[0][x + 1]; // y축 고정
		}
		// 상 -> 하
		for (int y = 0; y < air1; y++) {
			map[y][C - 1] = map[y + 1][C - 1]; // x축 고정
		}

		// 우 -> 좌
		for (int x = C - 1; x > 0; x--) {
			map[air1][x] = map[air1][x - 1]; // y축 고정
		}

		// 정화된 공기 (공기청정기 자체 이동 X)
		map[air1][1] = 0;

		// 하단부 공기청정기: 시계방향

		// 상 -> 하
		for (int y = air2 + 1; y < R - 1; y++) {
			map[y][0] = map[y + 1][0];
		}

		// 좌 -> 우
		for (int x = 0; x < C - 1; x++) {
			map[R - 1][x] = map[R - 1][x + 1];
		}

		// 하 -> 상
		for (int y = R - 1; y > air2; y--) {
			map[y][C - 1] = map[y - 1][C - 1];
		}

		// 우 -> 좌
		for (int x = C - 1; x >= 1; x--) {
			map[air2][x] = map[air2][x - 1];
		}
		// 정화된 공기 (공기청정기 자체 이동 X)
		map[air2][1] = 0;

	}

	private static void spread() {
		Queue<Loc> q = new LinkedList<Loc>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					q.offer(new Loc(i, j, map[i][j]));
				}
			}
		}

		while (!q.isEmpty()) {
			Loc temp = q.poll();
			int count = 0;
			int amount = temp.amount / 5;

			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= R || nx >= C)
					continue;
				if (map[ny][nx] == -1)
					continue;
				count++;
				map[ny][nx] += amount;

			}
			map[temp.y][temp.x] -= amount * count;
		}

	}

	static class Loc {
		int y;
		int x;
		int amount; // 확산전 미세먼지 값

		public Loc(int y, int x, int amount) {
			this.y = y;
			this.x = x;
			this.amount = amount;
		}

	}

}

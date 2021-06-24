package d0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 백준 아기상어
public class BOJ16236 {

	static int N, result = 0;
	static int[][] map;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static Loc shark;

	static class Loc { // 상어위치, 물고기위치용 구조체
		int y, x, size = 2, count, time; // 상어크기 시작 : 2

		public Loc(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time; // 초당 시간 => 이동 거리
		}

		// 람다정렬위해 get메소드 생성
		public int getY() {
			return y;
		}

		public int getX() {
			return x;
		}

		public int getTime() {
			return time;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Loc(i, j, 0);
				}
			}
		}

		while (true) {
			int temp = BFS();
			if (temp == -1)
				break;
			else
				result += temp;
		}

		System.out.println(result);

	}

	private static int BFS() {

		boolean[][] visited = new boolean[N][N]; // 매회마다 새롭게 방문배열, 리스트, 큐 초기화함
		Queue<Loc> q = new LinkedList<>();
		ArrayList<Loc> fishList = new ArrayList<>();
		q.offer(new Loc(shark.y, shark.x, 0)); // 상어 y 좌표, x 좌표, 이동시간(거리)
		visited[shark.y][shark.x] = true;

		while (!q.isEmpty()) {
			Loc cur = q.poll();

			for (int k = 0; k < 4; k++) {
				int ny = cur.y + dy[k];
				int nx = cur.x + dx[k];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N) // 경계검사
					continue;

				if (visited[ny][nx]) // 방문검사
					continue;

				if (map[ny][nx] > shark.size) // 자신보다 크면 지나갈 수 없음
					continue;

				visited[ny][nx] = true;
				if (map[ny][nx] < shark.size && map[ny][nx] != 0) { // 물고기 먹을때

					fishList.add(new Loc(ny, nx, cur.time + 1)); // 먹은 물고기 리스트 추가
					// q.offer(new Loc(ny, nx, cur.time + 1)); // 정렬후 검사에서 물고기를 지우고 상어위치를 갱신함
				} else { // 빈칸이거나 무시하고 지나갈때
					q.offer(new Loc(ny, nx, cur.time + 1)); // 상어 이동진행 (큐 삽입)
				}

			}
		}

		if (fishList.isEmpty()) // 먹을것이 존재하지않거나(자신보다큰물고기만있을때) 모든 물고기를 먹었으면 리스트는 비워져있음 (종료)
			return -1;

		else {
			// 람다(메소드 참조) 정렬 => 우선순위 오름차순 정렬 : 거리(먹기도달하는시간), y축(위), x축(왼)
			fishList.sort(
					Comparator.comparingInt(Loc::getTime).thenComparingInt(Loc::getY).thenComparingInt(Loc::getX));

//			fishList.sort(new Comparator<Loc>() {
//				@Override
//				public int compare(Loc o1, Loc o2) {
//					int r1 = o1.time - o2.time;
//					if (r1 == 0) {
//						int r2 = o1.y - o2.y;
//						if (r2 == 0)
//							return o1.x - o2.x;
//						else
//							return r2;
//					}
//					return r1;
//				}
//
//			});
			Loc fish = fishList.get(0); // 정렬된것중 첫번째값 으로해서 먹기시작
			map[shark.y][shark.x] = 0; // 맵에서 먹은 위치 물고기 삭제

			// 상어위치,이동시간 갱신
			shark.y = fish.y;
			shark.x = fish.x;
			shark.count++;

			if (shark.count == shark.size) { // 물고기사이즈만큼 먹었으면 상어크기갱신
				shark.size++;
				shark.count = 0;
			}

			return fish.time;
		}

	}

}

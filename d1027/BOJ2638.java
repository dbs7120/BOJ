package d1027;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 치즈
// 2636과 다른점: 적어도 2변이상이 실내온도와 접해있을때만 녹음
public class BOJ2638 {

	static int N, M, map[][]; // 세로 가로 치즈판
	static int time = 0;
	static boolean visited[][];

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// loop
		while (true) {
			time++;
			visited = new boolean[N][M];

			DFS(0, 0); // 바깥 치즈 찾기

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						int side = 0;
						for (int d = 0; d < 4; d++) {
							int ny = dy[d] + i;
							int nx = dx[d] + j;
							if (ny < 0 || nx < 0 || ny >= N || nx >= M)
								continue;
							if (map[ny][nx] == 2)
								side++;
						}
						if (side >= 2) {
							map[i][j] = 3; // 영향안주는 다른값으로 갱신하기
							cnt++;
						}
					}
				}
			}

			if (cnt == 0) {
				System.out.println(time - 1);
				break;
			}


		} // end loop

	}

	private static void DFS(int y, int x) {

		map[y][x] = 2;
		visited[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = dy[d] + y;
			int nx = dx[d] + x;
			if (ny < 0 || nx < 0 || ny >= N || nx >= M)
				continue;
			if (visited[ny][nx] || map[ny][nx] == 1)
				continue;
			DFS(ny, nx);
		}
	}
}

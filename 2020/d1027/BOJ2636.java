package d1027;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 치즈
public class BOJ2636 {

	static int N, M, map[][]; // 세로 가로 치즈판
	static int remain = 0;
	static int before;
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
				if (map[i][j] == 1)
					before++;
			}
		}

		// loop
		while (true) {
			remain = 0;
			time++;
			visited = new boolean[N][M];

			DFS(0, 0); // 바깥 치즈 찾기

			for (int i = 0; i < N; i++) { // 남은 치즈 찾기
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						for (int d = 0; d < 4; d++) {
							int ny = dy[d] + i;
							int nx = dx[d] + j;
							if (ny < 0 || nx < 0 || ny >= N || nx >= M)
								continue;
							if (map[ny][nx] == 2) {
								map[i][j] = 3;
							}
						}
					}
					if (map[i][j] == 1)
						remain++;
				}
			}

			// 종료 조건
			if (remain == 0)
				break;
			else
				before = remain; // 이전값 갱신

		} // end loop

		System.out.println(time);
		System.out.println(before);

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

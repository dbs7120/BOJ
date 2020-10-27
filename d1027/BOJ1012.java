package d1027;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유기농 배추
public class BOJ1012 {
	static int M, N, K, map[][]; // 가로, 세로, 배추수, 밭
	static boolean visited[][];
	static int answer;
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			answer = 0;
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];

			// 배추를 밭에 넣기
			int x, y;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++)
					if (map[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						DFS(i, j);
						answer++; // DFS 다돈후 지렁이수 증가시키기
					}
			}
			System.out.println(answer);
		}

	}

	private static void DFS(int y, int x) {

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= N || nx >= M)
				continue;
			if (visited[ny][nx] || map[ny][nx] == 0)
				continue;
			visited[ny][nx] = true;
			DFS(ny, nx);

		}

	}

}

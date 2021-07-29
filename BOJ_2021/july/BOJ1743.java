package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-07-29
// 음식물 피하기
public class BOJ1743 {
	static int N, M, K, map[][], result, size;
	static final int dy[] = { -1, 1, 0, 0 }, dx[] = { 0, 0, -1, 1 };
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		result = 0;
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[y - 1][x - 1] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					visited[i][j] = true;
					size = 0;
					DFS(i, j);
					result = Math.max(result, size);
				}
			}
		}
		bw.append(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

	private static void DFS(int y, int x) {
		size++;
		for (int d = 0; d < 4; d++) {
			int ny = dy[d] + y;
			int nx = dx[d] + x;
			if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || map[ny][nx] == 0)
				continue;
			visited[ny][nx] = true;
			DFS(ny, nx);

		}

	}
}

package d0830;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연결요소의 수 (DFS)
public class BOJ11724_dfs {

	static int N, M;
	static int[][] map;
	static boolean[] visited;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = 1; // 무방향
			map[end][start] = 1;

		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				DFS(i);
				count++;
			}
		}
		System.out.println(count);

	}

	public static void DFS(int start) {
		if (visited[start])
			return;

		visited[start] = true;

		for (int i = 1; i <= N; i++) {
			if (map[start][i] == 1) {
				DFS(i);
			}

		}
	}

}

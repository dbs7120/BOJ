package d0830;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 바이러스(DFS)
public class BOJ2606_dfs {

	static int V, N;
	static int[][] map;
	static boolean[] visited;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		visited = new boolean[V + 1];
		map = new int[V + 1][V + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = 1; // 양방향 그래프
			map[end][start] = 1;
		}

		DFS(1);

		System.out.println(count);

	}

	public static void DFS(int start) {
		visited[start] = true;
		for (int i = 1; i <= V; i++) {
			if (map[start][i] == 1 && !visited[i]) {
				count++;
				DFS(i);
			}
		}
	}

}

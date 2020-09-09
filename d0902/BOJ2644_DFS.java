package d0902;
import java.util.Scanner;

// 미세먼지 안녕!
public class BOJ2644_DFS {

	static int N, M;
	static int start, end;
	static int[][] map;
	static int[] dis;
	static boolean[] visited;
	static int answer = -1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		start = sc.nextInt();
		end = sc.nextInt();
		map = new int[N + 1][N + 1];
		dis = new int[N + 1];
		visited = new boolean[N + 1];
		M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			map[start][end] = 1;
			map[end][start] = 1;
		}
		DFS(start, 0);
		System.out.println(answer);
		sc.close();

	}

	public static void DFS(int cur, int cnt) {
		if (cur == end) {
			answer = cnt;
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (map[cur][i] == 0)
				continue;
			if (visited[i])
				continue;
			visited[i] = true;
			DFS(i, cnt + 1);
			visited[i] = false;
		}

	}

}

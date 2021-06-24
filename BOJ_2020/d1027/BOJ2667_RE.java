package d1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 단지번호붙이기
// DFS로 다시해결함
public class BOJ2667_RE {

	static int N, map[][], cnt;
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
	static boolean[][] visited;

	static List<Integer> apt = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		visited = new boolean[N][N];
		cnt = 0;

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					visited[i][j] = true;
					DFS(i, j);
					apt.add(cnt);
					cnt = 0;
				}
			}
		}

		Collections.sort(apt);
		System.out.println(apt.size());
		for (int e : apt)
			System.out.println(e);
	}

	private static void DFS(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N)
				continue;
			if (visited[ny][nx] || map[ny][nx] == 0)
				continue;
			cnt++;
			visited[ny][nx] = true;
			DFS(ny, nx);

		}

	}

}

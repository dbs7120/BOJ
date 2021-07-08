package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

// 2021-07-08
// 단지번호붙이기
// DFS풀이
public class BOJ2667 {

	static int N, map[][], cnt;
	static boolean visited[][];
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
	static ArrayList<Integer> apt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];
		cnt = 0;
		apt = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}

		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == '1') {
					cnt++;
					DFS(i, j);
					apt.add(cnt);
					cnt = 0;
				}
			}

		}

		Collections.sort(apt);

		bw.append(apt.size() + "\n");
		for (int e : apt)
			bw.append(e + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	private static void DFS(int y, int x) {
		visited[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = dy[d] + y;
			int nx = dx[d] + x;
			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || map[ny][nx] == '0')
				continue;
			visited[ny][nx] = true;
			cnt++;
			DFS(ny, nx);
		}

	}

}

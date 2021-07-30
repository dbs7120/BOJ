package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 2021-07-56
// 영역 구하기
public class BOJ2583 {
	static int N, M, K, map[][], result, temp;
	static final int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
	static ArrayList<Integer> sizeList;
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 세로
		N = Integer.parseInt(st.nextToken()); // 가로
		K = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		visited = new boolean[M][N];
		sizeList = new ArrayList<Integer>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++)
					map[y][x] = 1;
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					temp = 0;
					visited[i][j] = true;
					DFS(i, j);
					result++;
					sizeList.add(temp);
				}
			}
		}

		bw.append(result + "\n");
		Collections.sort(sizeList);

		for (int e : sizeList)
			bw.append(e + " ");

		bw.flush();
		bw.close();
		br.close();

	}

	private static void DFS(int y, int x) {
		temp++;
		for (int d = 0; d < 4; d++) {
			int ny = dy[d] + y;
			int nx = dx[d] + x;
			if (ny < 0 || nx < 0 || ny >= M || nx >= N || visited[ny][nx] || map[ny][nx] == 1)
				continue;
			visited[ny][nx] = true;
			DFS(ny, nx);
		}

	}
}

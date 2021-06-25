package jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-06-25
// 마인크래프트
/**
 * 최소~최대 높이로 각각 평탄화 후 각각의 시간중 최소시간을 찾기
 */
public class BOJ18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int map[][] = new int[N][M];

		int maxH = Integer.MIN_VALUE;
		int minH = Integer.MAX_VALUE;
		int resultHeight = 0;
		int resultTime = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (maxH < map[i][j])
					maxH = map[i][j];
				if (minH > map[i][j])
					minH = map[i][j];
			}
		}
		for (int h = minH; h <= maxH; h++) {
			int time = 0;
			int inventory = B;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] < h) { // 블록을 놓는 과정
						inventory -= (h - map[i][j]);
						time += (h - map[i][j]);
					} else if (map[i][j] > h) { // 블록을 파는 과정
						inventory += (map[i][j] - h);
						time += (map[i][j] - h) * 2;
					}
				}

			}

			if (inventory < 0)
				continue;
			if (resultTime >= time) {
				resultTime = time;
				resultHeight = h;
			}

		}
		bw.append(resultTime + " " + resultHeight + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}

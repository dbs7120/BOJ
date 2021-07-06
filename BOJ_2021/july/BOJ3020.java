package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-07-06
// 개똥벌레
public class BOJ3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int up[] = new int[H + 1]; // 석순
		int down[] = new int[H + 1]; // 종유석

		int min = Integer.MAX_VALUE;
		int cnt = 0;
		int sumUp[] = new int[H + 1]; // 석순 누적합
		int sumDown[] = new int[H + 1]; // 종유석 누적합

		for (int i = 1; i <= N; i += 2) { // 석순, 종유석에대해 각각 높이의 갯수
			up[Integer.parseInt(br.readLine())]++;
			down[Integer.parseInt(br.readLine())]++;
		}

		for (int i = 0; i < H; i++) { // 누적합
			sumUp[i + 1] = sumUp[i] + up[i];
			sumDown[i + 1] = sumDown[i] + down[i];
		}

		for (int i = 1; i <= H; i++) {
			int obstacle = (sumUp[H] - sumUp[i]) + (sumDown[H] - sumDown[H - i + 1]); // 석순의 합 + 종유석의 합
			if (min > obstacle) {
				min = obstacle;
				cnt = 1;
			} else if (min == obstacle)
				cnt++;

		}

		bw.append(min + " " + cnt + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}

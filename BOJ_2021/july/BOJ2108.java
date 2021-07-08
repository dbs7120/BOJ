package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 2021-07-08
// 통계학
public class BOJ2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int number[] = new int[N];
		int cnt[] = new int[8002];
		double sum = 0;
		int arithmetic_mean = 0; // 산술평균
		int median = 0; // 중앙값
		int mode = 0; // 최빈값
		int range = 0; // 범위

		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(br.readLine());
			sum += number[i];
			cnt[number[i] + 4000]++;
		}

		Arrays.sort(number);
		arithmetic_mean = (int) Math.rint(sum / N); // 음수값 반올림을 위해 rint 사용함
		median = number[N / 2];
		range = number[N - 1] - number[0];

		int cnt_max = 0;
		int flag = 0; // 최빈값 중 두 번째로 작은 값 파악 용
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] != 0) {
				if (cnt_max <= cnt[i]) {

					if (cnt_max < cnt[i])
						flag = 0;

					cnt_max = cnt[i];
					flag++;

					if (cnt_max == cnt[i] && flag <= 2)
						mode = i - 4000;

				}
			}
		}

		bw.append(arithmetic_mean + "\n");
		bw.append(median + "\n");
		bw.append(mode + "\n");
		bw.append(range + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}

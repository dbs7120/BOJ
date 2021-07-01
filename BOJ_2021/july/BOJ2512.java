package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-07-01
// 예산
/**
 * 절단기 높이에 대해 이분탐색 진행하기 ,int 형 범위내로 모두 가능
 */
public class BOJ2512 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int max, min, mid, temp, sum;
		temp = mid = max = min = sum = 0;

		int[] budget = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, budget[i]);
			sum += budget[i];
		}
		int M = Integer.parseInt(br.readLine());
		temp = M;

		if (sum > M) { // 모든 요청 배정될 수 없는 경우만 정수 상한액 계산
			while (min <= max) {
				mid = (max + min) / 2;
				temp = 0;
				for (int i = 0; i < N; i++) {
					temp += Math.min(budget[i], mid); // 임시값은 예산값과 중간값중 작은값으로 누적
				}
				if (temp <= M)
					min = mid + 1;
				else
					max = mid - 1;

			}
		}

		bw.append(max + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}

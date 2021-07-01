package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-07-01
// 나무 자르기
/**
 * 절단기 높이에 대해 이분탐색 진행하기 ,M이 2억이하이기때문에 범위 조심
 */
public class BOJ2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long max, min, mid, temp;
		temp = mid = max = min = 0;

		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}

		while (min <= max) {
			mid = (min + max) / 2; // 중간값 (이진탐색 시작지점)
			temp = 0;

			for (int i = 0; i < N; i++) {
				if (trees[i] > mid)
					temp += trees[i] - mid; // 임시값은 나무높이와 중간값의 차이의 누적값
			}

			if (temp >= M)
				min = mid + 1;
			else
				max = mid - 1;

		}

		bw.append(max + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}

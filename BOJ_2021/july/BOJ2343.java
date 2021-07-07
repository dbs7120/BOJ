package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-07-07
// 기타 레슨
/**
 * 블루레이의 값 길이의 최솟값을 이분탐색하기
 */
public class BOJ2343 {
	static int N, M, arr[], result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		int left, right;
		left = right = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right += arr[i];
			left = Math.max(left, arr[i]);
		}

		bw.append(BS(left, right) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

	private static int BS(int left, int right) {
		int high, low, mid, temp, cnt;
		low = left;
		high = right;

		while (low <= high) {
			temp = 0;
			cnt = 1;
			mid = (low + high) / 2;

			for (int i = 0; i < N; i++) {
				if (temp + arr[i] > mid) {
					temp = 0;
					cnt++; // 블루 레이수 증가
				}
				temp += arr[i];
			}

			if (cnt > M) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}
		return low;

	}
}

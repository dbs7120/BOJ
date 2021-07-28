package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2021-07-28
// 에라토스테네스의 체
public class BOJ2960 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean arr[] = new boolean[N + 1];
		Arrays.fill(arr, true);

		int cnt = 0;
		loop: for (int i = 2; i <= N; i++) {
			if (arr[i]) {
				arr[i] = false;
				cnt++;
				if (cnt == K) {
					bw.append(i + "\n");
					break;
				}

				for (int j = i * 2; j <= N; j += i) {
					if (arr[j]) {
						arr[j] = false;
						cnt++;
					}
					if (cnt == K) {
						bw.append(j + "\n");
						break loop;
					}
				}
			}

		}
		bw.flush();
		bw.close();
		br.close();
	}
}

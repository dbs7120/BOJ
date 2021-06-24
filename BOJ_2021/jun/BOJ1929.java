package jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2021-06-24
// 소수구하기
/**
 * (1 ≤ M ≤ N ≤ 1,000,000) 이므로 에라토스테네스 체 사용 필요
 */
public class BOJ1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean isPrime[] = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= N; i++) {
			if (!isPrime[i])
				continue;

			for (int j = 2 * i; j <= N; j += i) {
				if (!isPrime[j])
					continue;
				isPrime[j] = false;
			}

		}
		for (int i = M; i <= N; i++) {
			if (isPrime[i])
				bw.append(i + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}

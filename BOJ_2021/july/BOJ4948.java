package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 2021-07-28
// 베르트랑 공준
public class BOJ4948 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			bw.append(getPrime(N) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static int getPrime(int N) {
		int cnt = 0;
		boolean isPrime[] = new boolean[N * 2 + 1];
		Arrays.fill(isPrime, true);

		for (int i = 2; i <= N * 2; i++) {
			for (int j = i * 2; j <= N * 2; j += i) {
				isPrime[j] = false;
			}
		}
		for (int i = N + 1; i <= N * 2; i++) {
			if (isPrime[i])
				cnt++;
		}

		return cnt;
	}

}

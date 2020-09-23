package d0923;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1로만들기
public class BOJ1463 {

	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		dp = new int[1000001];

		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;

		int cnt;
		for (int i = 4; i <= N; i++) {
			if (i % 3 == 0) {
				cnt = Math.min(dp[i / 3], dp[i - 1]) + 1;
			} else if (i % 2 == 0) {
				cnt = Math.min(dp[i / 2], dp[i - 1]) + 1;
			} else {
				cnt = dp[i - 1] + 1;
			}
			dp[i] = cnt;
		}
		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);

	}


}

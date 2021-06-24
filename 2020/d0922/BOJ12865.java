package d0922;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 평범한 배낭
public class BOJ12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 물건수
		int K = Integer.parseInt(st.nextToken()); // 가방용량

		int[][] dp = new int[N + 1][K + 1];
		int[] value = new int[N + 1];
		int[] weight = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (weight[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(value[i] + dp[i - 1][j - weight[i]], dp[i - 1][j]);

				}
			}
		}
		// System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[N][K]);

	}

}

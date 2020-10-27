package d1014;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동전 0
public class BOJ11047 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int result = 0;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];

		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine().trim());
		}

		int i = N - 1;
		while (K != 0) {
			if (K >= coins[i]) {
				K -= coins[i];
				result++;
			} else {
				i--;
			}

		}
		System.out.println(result);

	}
}

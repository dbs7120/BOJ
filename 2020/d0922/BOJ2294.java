package d0922;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동전 2
public class BOJ2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		int[] dp = new int[money + 1];
		int[] coin = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			coin[i] = Integer.parseInt(br.readLine().trim());
		}

		for (int i = 1; i < dp.length; i++) {
			int min = 100001;
			for (int j = 0; j < cnt; j++) {
				if (i - coin[j] >= 0 && dp[i - coin[j]] + 1 < min) {
					min = dp[i - coin[j]] + 1;
				}
			}
			dp[i] = min;
		}
		if (dp[money] != 100001)
			System.out.println(dp[money]);
		else
			System.out.println(-1);
	}

}
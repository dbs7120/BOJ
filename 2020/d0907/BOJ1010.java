package d0907;

import java.util.Scanner;

// 다리놓기(이항계수 메모이제이션)
//5C3 = 4C2 + 4C3

public class BOJ1010 {

	static int N, M;
	static long dp[][] = new long[31][31];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			long result = DFS(N, M);
			System.out.println(result);
		}

		sc.close();

	}

	public static long DFS(int n, int r) {
		if (n == r || r == 0)
			return 1;
		if (dp[n][r] > 0)
			return dp[n][r];
		else
			return dp[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
	}

}

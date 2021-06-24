package d0907;

import java.math.BigDecimal;
import java.util.Scanner;

// 이항계수(메모이제이션), BigDecimal 사용
// 5C3 = 4C2 + 4C3

public class BOJ2407 {

	static int N, M;
	static long dp[][] = new long[101][101];
	static BigDecimal dpB[][] = new BigDecimal[101][101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		System.out.println(DFS(N, M));
		sc.close();

	}

	public static BigDecimal DFS(int n, int r) {
		if (n == r || r == 0)
			return BigDecimal.ONE;
		if (dpB[n][r] != null) // 주의
			return dpB[n][r];
		else
			return dpB[n][r] = DFS(n - 1, r - 1).add(DFS(n - 1, r));
	}

}

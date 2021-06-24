package d0727;

import java.util.Scanner;

public class BOJ2748 {

	static long[] memo = new long[10001];

	public static void main(String[] args) {
		memo[0] = 0;
		memo[1] = 1;

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(fib(num));
		sc.close();
	}

	private static long fib(int n) {
		if (n >= 2 && memo[n] == 0)
			memo[n] = fib(n - 1) + fib(n - 2);
		return memo[n];

	}
}
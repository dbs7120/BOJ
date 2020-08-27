package d0825;

import java.util.Scanner;

// 곱셈
public class BOJ1629 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
		System.out.println(expNmod(A, B, C));
		sc.close();
	}

	private static long expNmod(long a, long b, long c) {
		if (b == 0)
			return 1;
		long result = expNmod(a, b / 2, c);
		long temp = result * result % c;
		if (b % 2 == 0) { // b: 짝수
			return temp;
		} else {
			return temp * a % c; // temp사용하지않고 바로넣으면 long long 범위 넘어설 수 있음
		}
	}

}

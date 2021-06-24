package d0725;

import java.util.Scanner;

public class BOJ2609_1 {

	// GCD, LCM 유클리드 호제법
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int temp;
		if (a < b) {
			temp = a;
			a = b;
			b = temp;
		}
		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));
		sc.close();
	}

	static int gcd(int a, int b) {
		int r;
		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
}

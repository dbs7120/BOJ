import java.util.Scanner;

public class BOJ9613 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			long result = 0; // 입력값 < 1,000,000 이므로 int 이상의 자료형 필요
			int n = sc.nextInt();
			int[] num = new int[n];

			for (int i = 0; i < num.length; i++)
				num[i] = sc.nextInt();

			// 조합 알고리즘
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++)
					result += gcd(num[i], num[j]);
			}
			System.out.println(result);
		}
		sc.close();
	}

	static int gcd(int a, int b) {
		int r, temp;

		if (a < b) {
			temp = a;
			a = b;
			b = temp;
		}

		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}

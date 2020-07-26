import java.util.Scanner;

public class BOJ6588 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 에라토스테네스의 체
		boolean p[] = new boolean[1000001];
		p[0] = p[1] = true;
		for (int i = 2; i * i <= 1000000; i++) {
			if (!p[i]) {
				for (int j = i * i; j <= 1000000; j += i)
					p[j] = true;
			}
		}

		while (true) {
			boolean check = false;
			int a = sc.nextInt();

			if (a == 0)
				break;

			for (int j = 3; j <= a / 2; j ++) {
				if (!p[j] && !p[a - j]) {
					System.out.println(a + " = " + j + " + " + (a - j));
					check = true;
					break;
				}

			}
			if (!check)
				System.out.println("\"Goldbach's conjecture is wrong.\"");

		}
		sc.close();
	}
}

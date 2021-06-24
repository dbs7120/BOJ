package d0725;

import java.util.Scanner;

public class BOJ1978 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		int result = 0;
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			for (int j = num[i] - 1; j >= 1; j--) {
				if (j == 1)
					result++;
				if (num[i] % j == 0)
					break;
			}
		}

		System.out.println(result);

		sc.close();
	}
}

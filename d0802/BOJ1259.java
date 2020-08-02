package d0802;
import java.util.Scanner;

public class BOJ1259 {
	// 팰린드롬수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int N = sc.nextInt();
			if (N == 0)
				break;
			int len = (int) (Math.log10(N) + 1);
			int[] number = new int[len];


			int temp = N;
			int index = 0;
			while (temp != 0) {
				number[index] = temp % 10;
				temp /= 10;
				index++;
			}

			boolean flag = true;
			for (int i = 0; i <= len - 1; i++) {
				if (number[i] != number[len - i - 1]) {
					flag = false;
					break;
				} else {
					continue;
				}

			}
			System.out.println(flag ? "yes" : "no");

		}

		sc.close();
	}

}
package d0802;
import java.util.Scanner;

public class BOJ1789 {

	// 수들의 합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int plus = 1;
		long S = sc.nextLong();
		long sum = 0;
		int result = 0;
		while (true) {
			sum = sum + plus;
			result++;
			if (sum > S) {
				result--;
				break;
			}
			plus++;
		}
		System.out.println(result);

		sc.close();
	}

}
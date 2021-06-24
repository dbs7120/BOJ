package d0801;
import java.util.Scanner;

public class BOJ17173 {

	static int[] result = new int[1001]; // 공배수 중복제외 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] num = new int[M];
		int sum = 0;

		for (int i = 0; i < M; i++) {
			num[i] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			for (int j = 1; j <= N; j++) {
				if (j % num[i] == 0)
					result[j] = j;
			}
		}

		for (int i = 1; i <= N; i++) {
			sum += result[i];
		}


		System.out.println(sum);

		sc.close();
	}

}
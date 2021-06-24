package d0802;
import java.util.Scanner;

public class BOJ11050 {

	// 이항 계수1(1<=N<=10, 0<=K<=N)
	static int count = 0;
	static int N;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		comb(0, 0);
		System.out.println(count);

		sc.close();
	}

	static void comb(int cnt, int start) {
		if (cnt == K) {
			count++;
			return;
		} else {
			for (int i = start; i < N; i++) {
				comb(cnt + 1, i + 1);

			}
		}

	}

}
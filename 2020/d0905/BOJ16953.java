package d0905;
import java.util.Scanner;

public class BOJ16953 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		int cnt = 0;

		// B=>A로 도달하기
		while (true) {

			if (A == B) { // 도달 함
				System.out.println(cnt + 1);
				break;
			}
			if (A > B) {
				System.out.println(-1);
				break;
			}

			if (B % 10 == 1) { // B의 마지막자리가 1이면 1이 붙은경우
				B /= 10; // 10으로나눈 몫(나머지버려짐)
			} else if (B % 2 == 0) { // B가 짝수면 그전에서 X2 된 경우
				B /= 2; // 2로나누기
			} else {
				System.out.println(-1);
				break;
			}
			cnt++;

		}
		sc.close();

	}

}

package d0802;
import java.util.Scanner;

public class BOJ9012 {

	// 괄호
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int count = 0;

			String input = sc.next();

			if (input.length() % 2 == 1) {	// 길이홀수면 바로 종료
				System.out.println("NO");
				continue;
			}
			for (int i = 0; i < input.length(); i++) {
				char temp = input.charAt(i);
				if (temp == '(')
					count++;
				else
					count--;

				if (count < 0)	// ex: ())(() 처리
					break;
			}

			if (count == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}
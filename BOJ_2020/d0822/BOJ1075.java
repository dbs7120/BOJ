package d0822;
import java.util.Scanner;

//나누기
public class BOJ1075 {
	static int N, F;
	static int result;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		String str = sc.next(); // 100 ~ 20억 자연수
		F = sc.nextInt(); // 100 이하 자연수

		StringBuilder sb = new StringBuilder();
		sb.append(str);
		sb.setCharAt(str.length() - 1, '0');
		sb.setCharAt(str.length() - 2, '0');

		N = Integer.parseInt(sb.toString());

		for (int i = 0; i <= 99; i++) {
			if ((N + i) % F == 0) {
				result = i;
				break;
			}
		}

		System.out.printf("%s", result / 10 != 0 ? result : "0" + result);

		sc.close();
	}
}
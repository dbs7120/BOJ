package d0825;

import java.util.Scanner;

// 태보태보 총난타
public class BOJ17249 {

	public static void main(String[] args) {
		int left = 0;
		int right = 0;
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char mid = '('; // 나누는 기준점

		int temp = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '@') {
				temp++;
			}
			if (input.charAt(i) == mid) {
				left = temp; // 왼쪽주먹 저장
				temp = 0;
			}
		}
		right = temp; // 남은 @은 오른쪽 주먹
		System.out.println(left + " " + right);

		sc.close();

	}

}

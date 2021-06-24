package d0802;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ1764 {
	static String[] names;	// 입력용
	static String[] result;	// 듣보잡용

	// 듣보잡
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 듣도 못한 사람
		int M = sc.nextInt(); // 보도 못한 사람

		names = new String[N + M];

		for (int i = 0; i < N; i++) {	// 듣잡: 0 ~ N
			names[i] = sc.next();
		}
		for (int i = N; i < N + M; i++) {	// 보잡: N ~ N+M
			names[i] = sc.next();
		}

		Arrays.sort(names);	// [듣잡, 보잡] 정렬(사전순)
		int count = 0;

		for (int i = 0; i < N + M - 1; i++) {	// 듣보잡 배열공간 확인하기위함
			if (names[i].equals(names[i + 1])) {
				count++;
			}
		}

		result = new String[count];

		int count2 = 0;
		for (int i = 0; i < N + M - 1; i++) {
			if (names[i].equals(names[i + 1])) {
				result[count2] = names[i];
				count2++;
			}
			if (count2 == count)
				break;
		}
		Arrays.sort(result);	// 듣보잡정렬

		// System.out.println(Arrays.toString(result));

		System.out.println(count);	// 듣보잡수

		for (String e : result) {	// 듣보잡명단출력
			System.out.println(e);
		}

		sc.close();
	}

}
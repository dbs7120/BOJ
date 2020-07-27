package d0727;

public class BOJ4673 {

	static int N = 10001;
	static boolean[] selfNum = new boolean[N];

	public static void main(String[] args) {

		for (int i = 1; i < N; i++) {
			selfCon(i);
		}

		for (int i = 1; i < N; i++) {
			if (selfNum[i] == false) {
				System.out.println(i);
			}
		}
	}

	static void selfCon(int num) {
		int sum = num;
		while (true) {
			if (num == 0)
				break;
			sum = sum + num % 10;

			num = num / 10;
		}
		if (sum < N)
			selfNum[sum] = true;

	}

}
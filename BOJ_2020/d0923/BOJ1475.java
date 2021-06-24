package d0923;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 방번호
public class BOJ1475 {

	static int N;
	static String numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] number = new int[9]; // 0~8
		numbers = br.readLine().trim();

		for (int i = 0; i < numbers.length(); i++) {
			if (numbers.charAt(i) == '9' || numbers.charAt(i) == '6')
				number[6]++;
			else {
				number[numbers.charAt(i) - '0']++;
			}
		}
		if (number[6] % 2 == 0)
			number[6] = number[6] / 2;
		else
			number[6] = number[6] / 2 + 1;

		int result = 0;
		for (int i = 0; i < number.length; i++) {
			result = Math.max(number[i], result);
		}
		System.out.println(result);

	}

}

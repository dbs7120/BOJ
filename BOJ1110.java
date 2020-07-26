import java.util.Scanner;

public class BOJ1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int temp1 = 0, temp2 = N, count = 0;
		while (true) {
			temp1 = ((temp2 % 10) * 10) + ((temp2 % 10 + temp2 / 10) % 10);
			count++;

			if (N == temp1)
				break;

			temp2 = temp1;
		}
		System.out.println(count);
		sc.close();
	}
}

// 26: 2+6 = 8 -> 68
// 68: 6+8 = 14 -> 84
// 84: 8+4 = 12 -> 42

// 01: 0+1 = 1 -> 11

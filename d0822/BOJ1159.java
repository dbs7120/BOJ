package d0822;
import java.util.Scanner;

public class BOJ1159 {

	static int N;
	static String[] names;
	static int[] alphabet = new int['z' + 1];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		names = new String[N];
		for (int i = 0; i < N; i++) {
			names[i] = sc.next();
			for (int j = 'a'; j <= 'z'; j++) {
				if (names[i].charAt(0) == j)
					alphabet[j]++;
			}
		}

		boolean flag = false;
		for (int i = 'a'; i <= 'z'; i++) {
			if (alphabet[i] >= 5) {
				System.out.print((char) i);
				flag = true;
			}
		}

		if (!flag)
			System.out.println("PREDAJA");

		sc.close();

	}

}
import java.util.Scanner;

public class BOJ10809 {

	public static void main(String[] args) {
		int[] alphabet = new int[26];

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = -1;
		}

		for (int i = 0; i < str.length(); i++) {
			if (alphabet[str.charAt(i) - 97] == -1) {
				alphabet[str.charAt(i) - 97] = i;
			}
		}
		for (int e : alphabet)
			System.out.print(e + " ");
		sc.close();

	}
}

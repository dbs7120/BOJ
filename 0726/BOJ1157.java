import java.util.Scanner;

public class BOJ1157 {

	public static void main(String[] args) {

		int[] alphabet = new int[26];
		boolean flag = true;
		int temp = 0;
		int count = 0;

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		str = str.toUpperCase();

		for (int i = 0; i < str.length(); i++) {
			alphabet[(str.charAt(i) - 65)]++;
		}

		for (int i = 0; i < alphabet.length; i++) {
			if (count < alphabet[i]) {
				count = alphabet[i];
				temp = i;
			}
		}
		for (int i = 0; i < alphabet.length; i++) {
			if (count == alphabet[i] && i != temp) {
				flag = false;
				break;
			}
		}

		if (flag)
			for (int i = 0; i < alphabet.length; i++) {
				if (count == alphabet[i])
					System.out.printf("%c\n", i + 65);
			}
		else
			System.out.println("?");

		sc.close();
	}
}

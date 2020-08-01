package d0801;
import java.util.Scanner;

public class BOJ5622 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		int result = 0;

		for (int i = 0; i < str.length(); i++)
			result += chartoInt(str.charAt(i)) + 1;

		System.out.println(result);

		sc.close();
	}

	static int chartoInt(char input) {
		switch (input) {
		case 'A':
		case 'B':
		case 'C':
			return 2;
		case 'D':
		case 'E':
		case 'F':
			return 3;
		case 'G':
		case 'H':
		case 'I':
			return 4;
		case 'J':
		case 'K':
		case 'L':
			return 5;
		case 'M':
		case 'N':
		case 'O':
			return 6;
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
			return 7;
		case 'T':
		case 'U':
		case 'V':
			return 8;
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
			return 9;
		default:
			return 1;
		}
	}

}
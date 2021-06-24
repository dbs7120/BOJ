package d0924;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 크로아티아 알파벳
public class BOJ2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int result = 0;
		int i = 0;
		while (i < str.length()) {
			char cur = str.charAt(i);
			if (cur == 'c') {
				if (i + 1 < str.length() && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')) {
					i++;
				}
			} else if (cur == 'd') {
				if (i + 1 < str.length() && (str.charAt(i + 1) == '-')) {
					i++;
				}
				else if (i + 2 < str.length() && (str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=')) {
					i += 2;
				}
			} else if (cur == 'l') {
				if (i + 1 < str.length() && (str.charAt(i + 1) == 'j')) {
					i++;
				}
			} else if (cur == 'n') {
				if (i + 1 < str.length() && (str.charAt(i + 1) == 'j')) {
					i++;
				}
			} else if (cur == 's') {
				if (i + 1 < str.length() && (str.charAt(i + 1) == '=')) {
					i++;
				}
			} else if (cur == 'z') {
				if (i + 1 < str.length() && (str.charAt(i + 1) == '=')) {
					i++;
				}
			}

			if ((cur >= 'A' && cur <= 'Z') || (cur >= 'a' && cur <= 'z')) {
				result++;

			}
			i++;

		}
		System.out.println(result);

	}

}

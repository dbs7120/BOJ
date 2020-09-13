package d0912;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 균형잡힌 세상
public class BOJ4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			Stack<Character> st = new Stack<Character>();
			boolean isTrue = true;
			String str = br.readLine();
			if (str.equals(".")) {
				break;
			}
			for (int i = 0; i < str.length(); i++) {
				char temp = str.charAt(i);
				if (temp == '(' || temp == '[') {
					st.push(temp);
				}

				if (temp == ')' || temp == ']') {
					char temp2 = ' ';
					if (!st.isEmpty()) {
						temp2 = st.pop();
						if (temp2 == '(' && temp == ']') {
							isTrue = false;
							break;
						} else if (temp2 == '[' && temp == ')') {
							isTrue = false;
							break;
						}
					} else {
						isTrue = false;
						break;
					}
				}
			}
			if (!st.isEmpty())
				isTrue = false;

			if (isTrue) {
				bw.append("yes\n");
			} else {
				bw.append("no\n");
			}
		}

		bw.flush();
		bw.close();

	}

}
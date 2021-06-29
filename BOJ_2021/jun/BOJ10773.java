package jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 2021-06-29
// 제로
public class BOJ10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int result = 0;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());

			if (arr[i] != 0)
				s.push(arr[i]);
			else
				s.pop();
		}

		while (!s.isEmpty()) {
			result += s.pop();
		}

		bw.append(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}

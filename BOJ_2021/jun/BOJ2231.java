package jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2021-06-30
// 분해합
public class BOJ2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int sum, temp;
		int result = 0;
		for (int i = 1; i <= N; i++) {
			temp = sum = i;

			int length = (int) (Math.log10(i) + 1);
			int index = (int) Math.pow(10, length - 1);

			for (int j = 1; j <= length; j++) {
				sum += temp / index;
				temp = temp - index * (temp / index);
				index /= 10;
			}

			if (sum == N) {
				result = i;
				break;
			}

		}
		bw.append(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

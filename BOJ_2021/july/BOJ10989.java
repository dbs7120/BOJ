package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2021-07-08
// 수 정렬하기 3
public class BOJ10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int number[] = new int[10_001];

		for (int i = 0; i < N; i++)
			number[Integer.parseInt(br.readLine())]++;

		for (int i = 0; i < number.length; i++) {
			if (number[i] == 0)
				continue;
			for (int j = 0; j < number[i]; j++)
				bw.append(i + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}

package jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2021-06-30
// 부녀회장이 될테야
public class BOJ2775 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] apart = new int[15][15];

		// 0층 초기화
		for (int i = 1; i <= 14; i++)
			apart[0][i] = i;

		// 모든층수 다구해놈
		for (int i = 1; i <= 14; i++) {
			int temp = 0;
			for (int j = 1; j <= 14; j++) {
				if (j == 1) {
					apart[i][j] = 1;
					temp += apart[i][j];
				} else {
					temp += apart[i - 1][j];
					apart[i][j] = temp;
				}
			}
		}

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());

			bw.append(apart[K][N] + "\n");
			bw.flush();
		}

		bw.close();
		br.close();

	}
}

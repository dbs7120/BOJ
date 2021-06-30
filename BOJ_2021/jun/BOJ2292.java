package jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2021-06-30
// 벌집
/**
 * 각층의 마지막부분 식: 7 = 1(그전층) + 6 * 1(증가량), 19 = 7(그전층) + 6 * 2(증가량)
 */
public class BOJ2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int endRoom = 1;
		int floor = 1;
		while (true) {
			endRoom = endRoom + 6 * floor;
			if (endRoom >= N)
				break;
			floor++;
		}

		bw.append(N == 1 ? "1\n" : floor + 1 + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}

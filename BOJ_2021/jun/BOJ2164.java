package jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// 2021-06-29
// 카드2
public class BOJ2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			bw.append(1 + "\n");

		} else {
			Queue<Integer> q = new LinkedList<>();
			boolean toggle = true;

			for (int i = 1; i <= N; i++)
				q.offer(i);

			while (!q.isEmpty()) {
				int temp = q.poll();

				if (q.isEmpty()) {
					bw.append(temp + "\n");
					break;
				}

				if (toggle) {
					toggle = false;
				} else {
					q.offer(temp);
					toggle = true;
				}
			}

		}
		bw.flush();
		bw.close();
		br.close();

	}

}

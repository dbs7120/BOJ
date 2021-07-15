package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

// 2021-07-15
// 최대 힙
public class BOJ11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			if (number != 0) {
				pq.offer(number);
			} else {
				if (pq.isEmpty()) {
					bw.append("0\n");
				} else {
					bw.append(pq.poll() + "\n");
				}
			}

		}
		bw.flush();
		bw.close();
		br.close();
	}
}

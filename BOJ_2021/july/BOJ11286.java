package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

// 2021-07-15
// 절대값 힙
public class BOJ11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) < Math.abs(o2))
					return -1;
				else if (Math.abs(o1) > Math.abs(o2))
					return 1;
				else {
					if (o1 > o2)
						return 1;
					else
						return -1;
				}
			}
		});

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

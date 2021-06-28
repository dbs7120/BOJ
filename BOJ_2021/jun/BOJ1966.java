package jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2021-06-28
// 프린터 큐
public class BOJ1966 {

	static class Paper {
		int idx, priority;

		public Paper(int idx, int priority) {
			this.idx = idx;
			this.priority = priority;
		}

		@Override
		public String toString() {
			return "Paper [idx=" + idx + ", priority=" + priority + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Paper[] list = new Paper[N];
			int max[] = new int[N];

			st = new StringTokenizer(br.readLine());

			int temp = 0;
			Queue<Paper> q = new LinkedList<Paper>();
			for (int i = 0; i < N; i++) {
				temp = Integer.parseInt(st.nextToken());
				list[i] = new Paper(i, temp);
				max[i] = temp;
				q.offer(list[i]);
			}

			Arrays.sort(max);

			int idx = N - 1; // 우선순위 배열용
			int cnt = 0;
			while (!q.isEmpty()) {
				Paper cur = q.poll();

				if (cur.idx == M && cur.priority == max[idx]) {
					cnt++;
					break;
				}

				if (cur.priority == max[idx]) {
					idx--;
					cnt++;

				} else {
					q.offer(new Paper(cur.idx, cur.priority));
				}

			}
			bw.append(cnt + "\n");

		}

		bw.flush();
		bw.close();
		br.close();

	}

}

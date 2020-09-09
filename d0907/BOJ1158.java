package d0907;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 요세푸스(큐사용)
public class BOJ1158 {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		bw.write("<");

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		while (!q.isEmpty()) {
			for (int i = 1; i < K; i++) {
				q.offer(q.poll());

			}
			bw.write(String.valueOf(q.poll()) + ", ");
			if (q.size() == 1) {
				bw.write(String.valueOf(q.poll()));
			}
		}

		bw.write(">");

		bw.flush();
		bw.close();

	}
}

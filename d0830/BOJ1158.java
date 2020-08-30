package d0830;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 요세푸스 순열
public class BOJ1158 {

	static int N, K;
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		int pos = 0, end = 0, count = 0;

		while (true) {
			pos++;
			if (pos > N) { // 원형구조
				pos = 1;
			}
			if (!visited[pos]) {
				count++;
				if (count == K) {
					visited[pos] = true;
					result.add(pos);
					count = 0;
					end++;
				}
			}
			if (end == N)
				break;
		}


		bw.write("<");
		int idx = 1;
		for (int e : result) {
			bw.write(String.valueOf(e));
			idx++;
			if (idx <= N) {
				bw.write(", ");
			}
		}
		bw.write(">");

		bw.flush();
		bw.close();

	}

}

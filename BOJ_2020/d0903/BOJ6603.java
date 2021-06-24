package d0903;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ6603 {
	static int K, R = 6;
	static int[] arr, input;
	static boolean[] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			K = Integer.parseInt(st.nextToken());
			if (K == 0)
				break;

			input = new int[K];
			visited = new boolean[K];
			arr = new int[K];

			for (int i = 0; i < K; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			DFS(0, 0);
			bw.write("\n");
		}
		bw.flush();
		bw.close();

	}

	public static void DFS(int idx, int cnt) throws IOException {
		if (cnt == R) {
			for (int i = 0; i < R; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");

			return;
		}

		for (int i = idx; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[cnt] = input[i];
				DFS(i + 1, cnt + 1);
				visited[i] = false;

			}
		}

	}

}

package d0912;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 블랙잭
public class BOJ2798 {

	static int N, M;
	static int input[];
	static int arr[];
	static boolean visited[];
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		input = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		DFS(0, 0);
		bw.append(result + "\n");
		bw.flush();
		bw.close();

	}

	public static void DFS(int cnt, int idx) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += arr[i];
			}
			if (sum <= M) {
				// System.out.println(sum);
				result = Math.max(result, sum);
			}
			return;
		}
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[cnt] = input[i];
				DFS(cnt + 1, i + 1);
				visited[i] = false;
			}
		}
	}

}
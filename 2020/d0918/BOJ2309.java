package d0918;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 일곱난쟁이(DFS)
public class BOJ2309 {

	static int N = 9;
	static int R = 7;
	static int[] input = new int[N + 1];
	static int[] arr = new int[R];
	static boolean[] visited = new boolean[N];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

		for (int i = 1; i <= 9; i++) {
			input[i] = Integer.parseInt(br.readLine().trim());
		}
		DFS(0, 0);

	}

	public static void DFS(int cnt, int idx) {
		if (cnt == R) {
			int sum = 0;
			for (int i = 0; i < R; i++) {
				sum += arr[i];
			}
			if (sum == 100) {
				Arrays.sort(arr);
				for (int e : arr) {
					System.out.println(e);
				}
				System.exit(0);
			}
			return;
		}
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[cnt] = input[i + 1];
				DFS(cnt + 1, i + 1);
				visited[i] = false;

			}
		}

	}
}

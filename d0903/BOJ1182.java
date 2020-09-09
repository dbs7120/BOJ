package d0903;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {

	static int N, S;
	static int[] arr;
	static boolean[] visited;
	static int result = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		DFS(0);
		if (S == 0)
			result -= 1; // 공집합일때의 감안
		System.out.println(result);

	}

	public static void DFS(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i])
					sum += arr[i];
			}
			if (sum == S)
				result++;

			return;
		}
		visited[cnt] = true;
		DFS(cnt + 1);
		visited[cnt] = false;
		DFS(cnt + 1);

	}

}

package d0822;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

//N과 M (6)
public class BOJ15655 {
	static int n;
	static int m;
	static boolean visit[];
	static int[] input, numbers;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visit = new boolean[n + 1];
		input = new int[n + 1];
		numbers = new int[n + 1];
		for (int i = 1; i <= n; i++) { // 숫자 사용자 입력
			input[i] = sc.nextInt();
		}
		Arrays.sort(input); // 수열은 사전순 증가값으로
		DFS(1, 0);
		bw.flush();
		bw.close();
		sc.close();
	}

	public static void DFS(int idx, int cnt) throws IOException {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				bw.write(numbers[i] + " ");
			}
			bw.write("\n");
			return;
		}

		for (int i = idx; i <= n; i++) {
			if (!visit[i]) {
				visit[i] = true; // 방문체크
				numbers[cnt] = input[i];
				DFS(i+1, cnt + 1); // 다음 재귀
				visit[i] = false; // 선택뒤 미방문(백트래킹)
			}
		}
	}

}

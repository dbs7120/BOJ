package d0822;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

//N과 M (9)
public class BOJ15663 {
	static int n;
	static int m;
	static int[] input, numbers;
	static boolean[] visit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int startCnt = 0;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		input = new int[n + 1];
		numbers = new int[n + 1];
		visit = new boolean[n + 1];
		for (int i = 1; i <= n; i++) { // 숫자 사용자 입력
			int temp = sc.nextInt();
			for (int j = 1; j <= n; j++) {
				input[i] = temp;
			}
		}
		Arrays.sort(input); // 수열은 사전순 증가값으로
		DFS(0);
		bw.flush();
		bw.close();
		sc.close();
	}

	public static void DFS(int cnt) throws IOException {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				bw.write(numbers[i] + " ");
			}
			bw.write("\n");
			return;
		}

		int same = 0;
		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				if (same == input[i]) { // 중복 넘기기
					same = input[i]; // 중복 체크값 갱신
					continue;
				}
				visit[i] = true;
				numbers[cnt] = input[i];
				same = input[i]; // 중복 체크값 갱신
				DFS(cnt + 1); // 다음 재귀
				visit[i] = false;
			}

		}
	}

}

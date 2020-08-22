package d0822;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

//N과 M (7)
public class BOJ15656 {
	static int n;
	static int m;
	static int[] input, numbers;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		input = new int[n + 1];
		numbers = new int[n + 1];
		for (int i = 1; i <= n; i++) { // 숫자 사용자 입력
			input[i] = sc.nextInt();
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

		for (int i = 1; i <= n; i++) {
			numbers[cnt] = input[i];
			DFS(cnt + 1); // 다음 재귀
		}
	}

}

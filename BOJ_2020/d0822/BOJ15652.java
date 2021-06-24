package d0822;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//N과 M (4)
public class BOJ15652 {
	static int n;
	static int m;

	static int[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n + 1];
		DFS(0);

		bw.flush();
		bw.close();
		sc.close();

	}

	public static void DFS(int cnt) throws IOException {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (cnt > 0 && i < arr[cnt - 1]) { // 조건추가: 수열이 증가하는 형태만
				continue;
			}
			arr[cnt] = i; // 선택
			DFS(cnt + 1); // 다음 재귀
		}
	}

}

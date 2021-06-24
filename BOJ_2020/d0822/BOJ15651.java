package d0822;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//N과 M (3) => 중복 순열 ( n Π m )
//BW 미사용시 시간초과
public class BOJ15651 {
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

	public static void DFS(int cnt) throws IOException { // 중복 순열
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			arr[cnt] = i; // 선택
			DFS(cnt + 1); // 다음 재귀
		}
	}

}

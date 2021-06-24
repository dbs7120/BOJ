package d0912;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 영화감독 숌
public class BOJ1436 {

	static int N;
	static int title = 1666;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken().trim());
		if (N == 1) {
			bw.write("666\n");
		} else {
			int cnt = 1;
			while (true) {
				int temp = title;
				int cnt6 = 0;
				while (temp != 0) {
					if (cnt6 == 3)
						break;
					if (temp % 10 == 6)
						cnt6++;
					else
						cnt6 = 0;
					temp /= 10;
				}
				if (cnt6 == 3) {
					cnt++;
				}
				if (cnt == N)
					break;
				title++;
			}
			bw.write(title + "\n");
		}

		bw.flush();
		bw.close();

	}

}
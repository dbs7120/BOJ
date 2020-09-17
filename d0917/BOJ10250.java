package d0917;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// ACM 호텔
public class BOJ10250 {
	static int H, W, N;
	static int resultY, resultX;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			int cnt = 1;
			loop: for (int x = 0; x < W; x++) {
				for (int y = 0; y < H; y++) {
					if (cnt == N) {
						resultY = y;
						resultX = x;
						break loop;
					}
					cnt++;
				}
			}

			bw.write(String.valueOf(resultY + 1));

			if (resultX + 1 < 10)
				bw.write("0" + String.valueOf(resultX + 1) + "\n");
			else
				bw.write(String.valueOf(resultX + 1) + "\n");
		}
		bw.flush();
		bw.close();

	}
}

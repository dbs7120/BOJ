package d0912;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 네 번째 점
public class BOJ3009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] rect = new int[3][2];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			rect[i][0] = Integer.parseInt(st.nextToken());
			rect[i][1] = Integer.parseInt(st.nextToken());
		}

		int x = 0, y = 0;
		if (rect[0][0] == rect[1][0]) {
			x = rect[2][0];
		} else if (rect[0][0] == rect[2][0]) {
			x = rect[1][0];
		} else if (rect[1][0] == rect[2][0]) {
			x = rect[0][0];
		}

		if (rect[0][1] == rect[1][1]) {
			y = rect[2][1];
		} else if (rect[0][1] == rect[2][1]) {
			y = rect[1][1];
		} else if (rect[1][1] == rect[2][1]) {
			y = rect[0][1];
		}
		bw.write(x + " " + y + "\n");
		bw.flush();
		bw.close();

	}

}
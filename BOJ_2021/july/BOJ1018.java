package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-07-02
// 체스판 다시 칠하기
/**
 * 흰색우선판, 검은색우선판을 만들어 비교하는형식우로 해결함
 */
public class BOJ1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		final char wChess[][] = new char[8][8];
		final char bChess[][] = new char[8][8];

		String wline = "WBWBWBWB";
		String bline = "BWBWBWBW";

		for (int i = 0; i < 8; i += 2) {
			for (int j = 0; j < 8; j++) {
				wChess[i][j] = wline.charAt(j);
				bChess[i][j] = bline.charAt(j);
			}
		}
		for (int i = 1; i < 8; i += 2) {
			for (int j = 0; j < 8; j++) {
				wChess[i][j] = bline.charAt(j);
				bChess[i][j] = wline.charAt(j);
			}
		}

		char board[][] = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}

		int wmin = Integer.MAX_VALUE;
		int bmin = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int cnt, yy, wtemp, btemp; // 체스 판 칸수 , 비교y좌표(상수배열첨자용), 흰색우선판 칠하는수, 검은색우선판 칠하는수
				cnt = yy = wtemp = btemp = 0;
				loop: for (int y = i; y < i + 8; y++) {
					if (y >= N)
						break;
					int xx = 0; // 비교 x좌표(상수배열첨자용)
					for (int x = j; x < j + 8; x++) {
						if (x >= M)
							break loop; // 비교하는 x가 M을 넘어서면 만들어질수 없으므로 바로 탈출

						if (wChess[yy][xx] != board[y][x])
							wtemp++;

						if (bChess[yy][xx] != board[y][x])
							btemp++;

						cnt++;
						xx++;
					}

					yy++;

				}
				if (cnt == 64) { // 체스가 모두 되었을때만 (64개 모두비교했을때만 성공)
					wmin = Math.min(wmin, wtemp);
					bmin = Math.min(bmin, btemp);
				}

			}
		}

		bw.append(Math.min(wmin, bmin) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}

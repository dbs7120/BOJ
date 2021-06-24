package d0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 행복한지 슬픈지
public class BOJ10769 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int hCnt = 0, sCnt = 0;

		for (int i = 0; i <= str.length() - 2; i++) {

			if (str.charAt(i) == ':' && str.charAt(i + 1) == '-') {
				if (str.charAt(i + 2) == ')') {
					hCnt++;
				}

				if (str.charAt(i + 2) == '(') {
					sCnt++;
				}

			}
		}

		if (hCnt == 0 && sCnt == 0)
			System.out.println("none");
		else if (hCnt > sCnt)
			System.out.println("happy");
		else if (hCnt < sCnt)
			System.out.println("sad");
		else
			System.out.println("unsure");

	}

}

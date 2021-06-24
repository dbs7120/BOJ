package d0725;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class BOJ15552 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int T = Integer.parseInt(br.readLine()); // BufferedReader는 라인단위 문자열로 받음

		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			String[] word = str.split(" ");
			int A = Integer.parseInt(word[0]);
			int B = Integer.parseInt(word[1]);
			bw.write((A + B) + "\n");
		}
		bw.flush();
		bw.close();
	}
}

package d0830;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 소음
public class BOJ2935 {

	static String A, B;
	static String oper;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		A = br.readLine();
		oper = br.readLine();
		B = br.readLine();
		int lenA = A.length();
		int lenB = B.length();

		if (oper.equals("+")) {
			if (lenA > lenB) {
				bw.write("1");
				for (int i = 0; i < lenA - lenB - 1; i++) {
					bw.write("0");
				}
				bw.write("1");
				for (int i = 0; i < lenB - 1; i++) {
					bw.write("0");
				}

			} else if (lenA < lenB) {
				bw.write("1");
				for (int i = 0; i < lenB - lenA - 1; i++) {
					bw.write("0");
				}
				bw.write("1");
				for (int i = 0; i < lenA - 1; i++) {
					bw.write("0");
				}
			} else {
				bw.write("2");
				for (int i = 0; i < lenA - 1; i++) {
					bw.write("0");
				}

			}
		} else if (oper.equals("*")) {
			bw.write("1");
			for (int i = 0; i < lenA + lenB - 2; i++)
				bw.write("0");
		}

		bw.flush();
		bw.close();
	}
}

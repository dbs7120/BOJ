package jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2021-06-28
// Hashing
public class BOJ15829 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long result = 0;
		long r = 1;
		int mod = 1234567891;

		for (int i = 0; i < L; i++) {
			result += (str.charAt(i) - 'a' + 1) * r;
			result %= mod;
			r *= 31;
			r %= mod;
		}

		bw.append(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}

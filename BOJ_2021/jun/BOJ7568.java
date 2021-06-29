package jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ7568 {
	static class Person {
		int weight, height, rank;

		public Person(int weight, int height, int rank) {
			this.weight = weight;
			this.height = height;
			this.rank = rank;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Person[] array = new Person[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			array[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) // 값은것 비교 X
					continue;
				if (array[i].weight < array[j].weight && array[i].height < array[j].height) { // 2중 반복문으로 무게/키 비교
					array[i].rank++; // 둘다작을때 등수 숫자값 증가
				}

			}
			bw.append(array[i].rank + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}
}

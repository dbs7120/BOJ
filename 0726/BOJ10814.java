import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ10814 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Person[] person = new Person[N];

		for (int i = 0; i < N; i++) {
			person[i] = new Person(sc.nextInt(), sc.next());
		}

		Arrays.sort(person, new Comparator<Person>() {

			@Override
			// 나이순 정렬
			public int compare(Person p1, Person p2) {
				return p1.age - p2.age;
			}

		});

		for (int i = 0; i < N; i++) {
			// toString 출력
			System.out.println(person[i]);
		}
		sc.close();

	}

	public static class Person {

		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return age + " " + name;
		}
	}

}

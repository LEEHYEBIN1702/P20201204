package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import lambda.Student;

public class StreamExample3 {
	public static void main(String[] args) {
		String[] strs = "Java8-lambda-Hello".split(" "); // 스플릿 메소드를 쓰면 공란을 기준으로 나누어서 배열을 만들어줌.

		List<String> strList = Arrays.asList("Java8 lambda", "stream mapping");

		strList.stream()
		.flatMap((String t) -> Arrays.stream(t.split(" "))) // 위에서 스플릿 메소드로 스트링 타입 배열을 만들었기 때문에 스트링 타입으로 반환됨.
//	    .filter(s -> s.startsWith("s")) //스타트 위드 메소드를 써서 s로 시작하는 단어를 출력.
		.forEach(s -> System.out.println(s));

		strList.stream()
		.map((String t) -> t.toUpperCase())
		.forEach(s -> System.out.println(s));

		List<Student> students = Arrays.asList(
				new Student("송다희", "F", 80), new Student("윤태현", "M", 75),
				new Student("이혜빈", "F", 85), new Student("정병기", "M", 90));
		
		double avg = students.stream()
		.mapToInt(new ToIntFunction<Student>() { // 결과 값을 인트로 반환해주는 메소드.

			@Override
			public int applyAsInt(Student s) {
				System.out.println(s.getName() + "/" + s.getScore());
				return s.getScore();
			}

		}).average()
		.getAsDouble();
		System.out.println(avg);
	}

}

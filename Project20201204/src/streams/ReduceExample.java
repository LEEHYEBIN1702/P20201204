package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;

public class ReduceExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("Hong", 80),
				new Student("Hwang", 90),
				new Student("Park", 87)

		);
		int sum = list.stream().mapToInt(t -> t.getScore())// 학생 점수 합계...
				.sum();

		System.out.println("합계: " + sum);

		// reduce
		int result = list.stream()//
				.mapToInt(t -> t.getScore())
				.reduce(new IntBinaryOperator() {// 매개 값으로 받는 타입 , 반환되는 타입 둘 다 같음.
					@Override
					public int applyAsInt(int left, int right) {
						System.out.println("left: " + left + ", right: " + right);
						return left + right;
					}

				}).getAsInt();
		System.out.println("결과값: " + result);

		result = list.stream()//
				.mapToInt(t -> t.getScore())
				.reduce(0, (left, right) -> left + right);
		System.out.println("결과값: " + result);

		result = list.stream()//
				.mapToInt(t -> t.getScore())
				.reduce(0, (left, right) -> left + right);
		System.out.println("결과값: " + result);

		result = list.stream()//
				.mapToInt(t -> t.getScore())
				.reduce((left, right) -> (left + right) / 2)//
				.getAsInt(); //초기값이 없는 경우에는 getAsInt로 가져와야 함. 초기값이 있는 경우에는 적지 말아야함.
		System.out.println("평균값: " + result);
		

	}

}

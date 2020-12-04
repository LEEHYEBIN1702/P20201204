package stream;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamExample2 {
	public static void main(String[] args) {
		// 1 ~ 100
		// 짝수만 결과를 출력...

		// IntStream.rangeClosed(1, 100)
		// .filter(t -> t %2 ==0 ).forEach(s -> System.out.println(s));

		IntStream.rangeClosed(1, 100).filter(new IntPredicate() {

			@Override
			public boolean test(int value) {
				return value % 2 == 0;
			}

		}).forEach(new IntConsumer() {

			@Override
			public void accept(int value) {
				System.out.println(value);

			}

		});

		int sum = IntStream.rangeClosed(1, 100).filter(t -> t % 2 == 0).sum();

		int[] intAry = { 2, 6, 4, 8, 1, 9 };
		IntStream is = Arrays.stream(intAry);
		int min = is.min().getAsInt(); // min 메소드가 가져온 최솟값을 getAsInt로 다시 도출해냄.
		System.out.println("min: " + min);

		is = Arrays.stream(intAry);
		Double avg = is.average().getAsDouble();
		System.out.println("avg : " + avg);

		// 조건 (filter)
		Arrays.stream(intAry).filter((a) -> a % 2 == 0)
		                     .forEach((a) -> System.out.println(a));
	}

}

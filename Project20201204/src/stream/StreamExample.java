package stream;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.sql.rowset.Predicate;

public class StreamExample {
	public static void main(String[] args) {
		List<String> list = null;
		list = Arrays.asList("Hong", "Hwang", "Park", "Choi");
//		list.add("Kim");

		Stream<String> stream = list.stream();
		stream.filter((t) -> t.length() > 3)
		      .forEach((t) -> System.out.println(t));
		
		//BaseStream -> Stream<T>, IntStream, LongStream, DoubleStream
		// IntStream: Stream<Integer>, LongStream: Stream<LongStream>
		
		String[] strAry = {"Hong", "Hwang", "Park"};
		Stream<String> strStream = Arrays.stream(strAry);
		
		int[] intAry = {1, 2, 3, 4, 5};
		IntStream intStream = Arrays.stream(intAry);
		int sum = intStream.sum();  //각각의 요소들을 다 더하는 메소드.
		System.out.println("합: " + sum);
		
		double[] dblAry = {1.1, 2.2, 3.3, 4.4, 5.5};
		DoubleStream dblStream = Arrays.stream(dblAry);
		
		dblStream.forEach(new DoubleConsumer() {
			double result = 0;

			@Override
			public void accept(double value) {
				result +=value;
				System.out.println(result);
				
			}
			
		});
		
		IntStream is = IntStream.range(1, 10); //1부터 10 사이에 있는 숫자로 스트림을 만들겠다.
		is.forEach(n -> System.out.println(n));
//		is.sum(); 위에서 이미 사용한 스트림을 다시 호출하니 값이 비었다고 오류가 뜸. 또 쓰고 싶으면 그때 그때 새롭게 선언 해줘야 함.
		
		is = IntStream.rangeClosed(1, 10); // 1부터 10까지 포함해서 그 사이 있는 숫자로 스트림을 만들겠다.
		System.out.println("합: " +is.sum());
		
		Path path = Paths.get("list.txt");  //내용 보여주는 메소드
		try {
			Stream<String> stream1 = Files.lines(path);
			stream1.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		path = Paths.get("c:/");
		try {
			Stream<Path> pStream = Files.list(path);
			pStream.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}

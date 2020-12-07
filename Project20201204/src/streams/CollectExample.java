package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("Hong", 80), 
				new Student("Hwang", 90), 
				new Student("Park", 87)

		);

		List<Student> student80s = list.stream()//
		.filter(s -> s.getScore() / 10 == 8)//
//	    .forEach(System.out::println); //println도 투스트링 오버라이드를 만들어서 이런 식으로 줄여서 쓸 수 있음.
		.sorted() // 우선해주는 값으로 정렬 해주는 메소드 // 구현해주는 메소드가 Comparable 해야 한다.
		.collect(Collectors.toList()); // Collectors 클래스가 가지고 있는 toList()라는 메소드 호출.
//		.collect(Collectors.toSet()); // toSet 메소드도 가능.

		for (Student student : student80s) {
			System.out.println("이름: " + student.getName() + "/ 점수: " + student.getScore());
			
			
			
			

		
					Map<String, Integer> map = list.stream().filter(s -> s.getScore() / 10 == 8)//
					.sorted() // 우선해주는 값으로 정렬 해주는 메소드 // 구현해주는 메소드가 Comparable 해야 한다.
					.collect(//
					 Collectors.toMap(//
							
					(t) -> t.getName(),
				    (t) -> t.getScore()
					)
	  //
	  );
			Set<String> set = map.keySet();
			for(String key : set) {
				System.out.println("Key: " + key + ", Val: " + map.get(key));
			}
	}

		
		
		
		
//		for (Student student : student80s) {
//			System.out.println("이름: " + student.getName() + "/ 점수: " + student.getScore());

//			list.stream()//
//					.filter(s -> s.getScore() / 10 == 8)//
//					.sorted() // 우선해주는 값으로 정렬 해주는 메소드 // 구현해주는 메소드가 Comparable 해야 한다.
//					.collect(//
//					 Collectors.toMap(//
							
//					new Function<Student, String>() {

//						@Override
//						public String apply(Student t) {
//							return t.getName();
//						}
//					}, new Function<Student, Integer>() {

//						@Override
//						public Integer apply(Student t) {
//							return t.getScore();
//						}
//					})
					
	  //
//	  );

//		}
		
		
	}

}

package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class LambdaExample {
	public static void main(String[] args) {

		List<Student> list = Arrays.asList(
				new Student("Hong", "MALE", 70), new Student("Hwang", "FEMALE", 80),
				new Student("Park", "MALE", 90), new Student("Choi", "FEMALE", 85));

		// 1. 여학생정보: 이름 - 점수.
		System.out.println("=============================================");
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				System.out.println("여학생 정보: " + student.getName() + "-" + student.getScore());

			}
		}

		// 2. 전체학생: 점수 80점 초과. 이름 - 점수.
		System.out.println("=============================================");
		for (Student student : list) {
			if (student.getScore() > 80) {
				System.out.println("80점 초과 학생 정보: " + student.getName() + "-" + student.getScore());

			}
		}

		// 3. 남학생의 총점: 남학생 총점: 160점;
		int sum = 0;
		System.out.println("=============================================");
		for (Student student : list) {
			if (student.getSex().equals("MALE")) {
				sum += student.getScore();
			}
		}
		System.out.println("남학생의 총점: " + sum);
		// 4. 여학생의 평균: 여학생 평균: 82.5점;
		int sum1 = 0;
		int count = 0;
		double avg = 0;
		System.out.println("=============================================");
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				count++;
				sum1 += student.getScore();
				avg = (double) sum1 / count;
			}
		}
		System.out.println("여학생의 평균: " + avg);
		
		
		
		
		
		System.out.println("=============================================");
		// 반복문 (반복자): 스트림 (반복자)
		// 스트림 생성 -> 소진.
		Stream<Student> stream = list.stream();
		stream.filter((t)-> t.getSex().equals("FEMALE"))
		// 지정한 요소만 필터해서 가져오는 메소드.
		.forEach ((Student t) -> System.out.println("여학생 정보: " + t.getName() + "-" + t.getScore()));
		// 스트림 각각 요소들에 대해 메소드를 구현해주라는 메소드.
		
		
		System.out.println("=============================================");
		stream = list.stream(); // 스트림을 또 쓰고 싶으면 다시 선언을 해줘야 함.
		stream.filter(new Predicate<Student>() {
		   @Override
			public boolean test(Student t) {
				return t.getScore() > 80;
			}
			
		}).forEach(new Consumer<Student>() {
			@Override
			public void accept(Student t) {
				System.out.println("80점 초과 학생 정보: " + t.getName() + "-" +t.getScore());
				
			}
			
		});
		
		System.out.println("=============================================");
	int sum2= list.stream().filter(t->t.getSex().equals("MALE"))
		.mapToInt(new ToIntFunction<Student>() { //가져온 결과를 인트 값으로 변환해주는 메소드.

			@Override
			public int applyAsInt(Student value) { //학생 클래스의 스코어만 가져오겠다.
				return value.getScore();
			} 
			
		}).sum(); // 그 결과를 섬으로 집계해보겠다.
	
	    System.out.println("남학생 총점:" + sum2);
	
	
	System.out.println("=============================================");
	double avg1 = list.stream().filter(t -> t.getSex().equals("FEMALE"))
	.mapToInt(s -> s.getScore())
	.average()
	.getAsDouble();
	
	System.out.println("여학생의 평균: " + avg);
	}
}
package streams;

public class Student implements Comparable <Student>{ //Comparable은 제너릭 타입이다. 그래서 뒤에 <Student> 해줌.

	private String name;
	private int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	@Override
	public int compareTo(Student o) { // 리턴 음수 값은 : 오름차순, 0은 같다, 양수 값은 : 내림차순
		//return this.score > o.score ? 1 : -1; //리턴 값 왼쪽이 크면 1 아니면 -1 
//		return this.score - o.score; // 음수 : 오름차순
		return o.score - this.score; // 양수 : 내림차순

	}
	
	

}

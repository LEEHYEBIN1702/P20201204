package streams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import lambda.Student;

public class StreamExample5 {

	public static void main(String[] args) {
		Connection conn = DAO.getConnection();
		List<StreamExample4VO> list = new ArrayList<>();
		try {
			String sql = "select * from emp1";
			PreparedStatement psmt //
					= conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				StreamExample4VO emp = new StreamExample4VO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("Salary"));
				emp.setDepartmentId(rs.getInt("department_id"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Stream<StreamExample4VO> stream = list.stream();
		stream.forEach(s -> s.showEmpInfo());
     	System.out.println();


		// 2. 선적부서 : 급여합계 (평균)

		System.out.println("40번 부서 사원. >>>");
		OptionalDouble avg = list.stream() 
		.filter(new Predicate<StreamExample4VO>() {

			@Override
			public boolean test(StreamExample4VO t) {
				return t.getDepartmentId() == 50;
			}
		}).mapToInt(new ToIntFunction<StreamExample4VO>() {

			@Override
			public int applyAsInt(StreamExample4VO t) {
				System.out.println(t.getFirstName() + "/" + t.getSalary());
				return t.getSalary();
			}
		}).average();
		avg.orElse(0.0); // avg 값이 없으면 0.0을 출력하라는 메소드.
		avg.ifPresent(new DoubleConsumer() {  // avg에 값이 있을 때만 가져오는 메소드. // 값이 없어서 오류가 뜨는 걸 방지하는 용도.
			@Override           //avg.orElse, avg.ifPresent 는 옵셔널 클래스 일 때만 쓸 수 있음.
			public void accept(double value) {
				System.out.println("평균: " + avg.orElse(0.0));
				
			} 
			
		});	
	}
}
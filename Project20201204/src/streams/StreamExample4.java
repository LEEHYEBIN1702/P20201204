package streams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import lambda.Student;

public class StreamExample4 {

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
		

		// 1. salary 10,000이상인 사원.
		System.out.println("salary가 10,000 이상인 사원.>>>");

		list.stream().filter(new Predicate<StreamExample4VO>() {

			@Override
			public boolean test(StreamExample4VO t) {
				return t.getSalary() > 10000;
			}

		}).forEach(s -> s.showEmpInfo());

//                list.stream().filter((t) -> t.getSalary() > 10000)
//					.forEach(s-> s.showEmpInfo());

		System.out.println();

		// 2. 선적부서 : 급여합계 (평균)

		System.out.println("선적부서: 급여 합계 (평균). >>>");
		double avg  = list.stream()
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

		}).average().getAsDouble();
		System.out.println("평균: " + avg);
		
//		list.stream().filter(t-> t.getDepartmentId() == 50)
//		.mapToInt((t)-> t.getSalary())
//		.average().getAsDouble();
		
		System.out.println();
		
		
		
		// 급여 5000 - 10000 사이의 직원
		
		System.out.println("급여 5000 ~ 10000 사이의 직원. >>>");
		
		list.stream().filter(new Predicate<StreamExample4VO>() {

			@Override
			public boolean test(StreamExample4VO t) {
				return t.getSalary() >5000  && t.getSalary() < 10000;
			}
			
		}).forEach(t -> t.showEmpInfo());
		

	}
}
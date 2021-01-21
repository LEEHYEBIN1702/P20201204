package streams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import oracle.net.aso.a;

public class p20201208 {
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

		
		// salary가 높은 사람 순으로 정렬.

		System.out.println("salary가 높은 사람 순으로 정렬.>>>");
		list.stream().filter(t -> t.getSalary() > 0)
		             .sorted()
		             .forEach(t -> t.showEmpInfo());
//		             .forEach(new Consumer<StreamExample4VO>() { // forEach는 Consumer 써야함.
//    		@Override
//			public void accept(StreamExample4VO t) {
//				t.showEmpInfo();

//			}

//		});
		System.out.println();
		System.out.println("first name 순으로 정렬.>>>");
		list.stream().sorted()
		             .forEach(t -> t.showEmpInfo());
			}
		
	}



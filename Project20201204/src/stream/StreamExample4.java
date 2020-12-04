package stream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StreamExample4 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt;
		ResultSet rs;
		String sql;
		conn = DAO.getConnection();
		List<StreamExample4VO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
		

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
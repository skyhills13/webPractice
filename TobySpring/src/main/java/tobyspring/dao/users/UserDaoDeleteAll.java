package tobyspring.dao.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoDeleteAll extends UserDao {

	@Override
	protected PreparedStatement makeStatement(Connection conn, String sqlQuery)
			throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(sqlQuery);
		return ps;
	}
}

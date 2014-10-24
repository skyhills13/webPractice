package tobyspring.dao.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllStatement implements StatementStrategy{

	@Override
	public PreparedStatement makePreparedStatement(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete from users");
		return ps;
	}

}

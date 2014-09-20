package tobyspring.dao.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import tobyspring.domain.users.User;

public class UserDao {
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public UserDao() {
	}

	public UserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void add(User user) throws ClassNotFoundException, SQLException {
		
		Connection conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
			"insert into users(id, name, password) values (?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection conn = dataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(
				"select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		conn.close();
	
		return user;
	}
	
	
}

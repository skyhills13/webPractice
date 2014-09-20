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
		User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
		
		rs.close();
		ps.close();
		conn.close();
	
		return user;
	}
	
	public void deleteAll() throws SQLException{
		Connection conn = dataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(
				"delete from users");
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	
	public int getCount() throws SQLException{
		Connection conn = dataSource.getConnection();
		
		int count;
		PreparedStatement ps = conn.prepareStatement(
				"select count(*) from users");
		ResultSet rs = ps.executeQuery();
		rs.next();
		count = rs.getInt(1);
		
		rs.close();
		ps.close();
		conn.close();
		return count;
	}
	
	
}

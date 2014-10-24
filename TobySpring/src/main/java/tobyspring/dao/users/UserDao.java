package tobyspring.dao.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;

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

	public void jdbcContextWithStatementStrategy(StatementStrategy statementStrategy) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			
			ps = statementStrategy.makePreparedStatement(conn);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			if( conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void add(final User user) throws ClassNotFoundException, SQLException {
		class AddStatement implements StatementStrategy{
			
			@Override
			public PreparedStatement makePreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement("insert into users(id, name, password) values (?, ?, ?)");
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getPassword());
				return ps;
			}
		}
		StatementStrategy statementStrategy = new AddStatement();
		jdbcContextWithStatementStrategy(statementStrategy);
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection conn = dataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(
				"select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		User user = null;
		if(rs.next()) {
			user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		}
		rs.close();
		ps.close();
		conn.close();
		
		if( user == null ) {
			throw new EmptyResultDataAccessException(1);
		}
		return user;
	}
	
	public void deleteAll() throws SQLException{
		StatementStrategy st = new DeleteAllStatement();
		jdbcContextWithStatementStrategy(st);
	}
	
	
	public int getCount() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int count = 0;
		
		try {
			conn = dataSource.getConnection();

			ps = conn.prepareStatement(
					"select count(*) from users");
			rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if( rs != null) {
				try {
					rs.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if ( ps != null) {
				try {
					ps.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if ( conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
	
}

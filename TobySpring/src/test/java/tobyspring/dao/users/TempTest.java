package tobyspring.dao.users;
import java.sql.SQLException;

import tobyspring.dao.users.UserDao;
import tobyspring.domain.users.User;


public class TempTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao dao = new UserDao();
		
		User user = new User();
		user.setId("dooby");
		user.setName("dobyJung");
		user.setPassword("ehqlehql");
		
		dao.add(user);
		
		System.out.println(user.getId() + " : 등록");
		
		User user2 = dao.get(user.getId());
		
		System.out.println(user2.getName());
		
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " : 조회 성공");
	}
}

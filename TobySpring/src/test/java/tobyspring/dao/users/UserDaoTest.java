package tobyspring.dao.users;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import tobyspring.domain.users.User;


public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = applicationContext.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("dby");
		user.setName("dbyJung");
		user.setPassword("ehqlehql");
		
		dao.add(user);
		
		System.out.println(user.getId() + " : 등록");
		
		User user2 = dao.get(user.getId());
		
		System.out.println(user2.getName());
		
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " : 조회 성공");
	}
}

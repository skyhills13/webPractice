package tobyspring.dao.users;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.sun.org.apache.xpath.internal.operations.Equals;

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
		
		User user2 = dao.get(user.getId());
		
		if(!user.getName().equals(user2.getName())) {
			System.out.println("테스트 실패 ( name ) ");
		} else if (!user.getPassword().equals(user2.getPassword())) {
			System.out.println("테스트 실패 ( password) ");
		} else {
			System.out.println("테스트 성공");
		}
	}
}

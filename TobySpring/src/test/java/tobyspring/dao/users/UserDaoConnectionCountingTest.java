package tobyspring.dao.users;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import tobyspring.domain.users.User;

public class UserDaoConnectionCountingTest {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext applicationConext = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		
		UserDao userdao = applicationConext.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("dobi");
		user.setName("dobiJung");
		user.setPassword("dobi");
		userdao.add(user);
		
		System.out.println(userdao.get("dobi").getName() + "등록 및 조회 성공");
		
		User user2 = new User();
		user2.setId("dob");
		user2.setName("dobJung");
		user2.setPassword("dob");
		userdao.add(user2);
		
		System.out.println(userdao.get("dob").getName() + "등록 및 조회 성공");
		
		CountingConnectionMaker countingConnectionMaker = applicationConext.getBean("connectionMaker", CountingConnectionMaker.class);
		//userDao를 사용할때마다 connection을 맺는 것이므로, 총 4가 나와야 함 
		System.out.println(countingConnectionMaker.getCounter());
		
	}
}

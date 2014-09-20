package tobyspring.dao.users;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import tobyspring.domain.users.User;


public class UserDaoTest {

	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException{
		
		ApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = applicationContext.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("ggyudori");
		user.setName("yoonsungJung");
		user.setPassword("ggg");
		dao.add(user);
		
		User user2 = dao.get(user.getId());
		
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
	}
}

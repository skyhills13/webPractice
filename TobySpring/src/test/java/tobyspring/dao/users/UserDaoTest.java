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
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		User user = new User("ggyudori", "yoonsungJung","ggg");
		dao.add(user);
		assertThat(dao.getCount(), is(1));
		
		User user2 = dao.get(user.getId());
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
	}
	
	@Test
	public void count() throws SQLException, ClassNotFoundException {
		ApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = applicationContext.getBean("userDao", UserDao.class);
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		User user1 = new User("dobo", "yoon", "dobopass");
		dao.add(user1);
		assertThat(dao.getCount(), is(1));
		User user2 = new User("doba", "sung", "dobapass");
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		User user3 = new User("dodo", "jung", "jungpass");
		dao.add(user3);
		assertThat(dao.getCount(), is(3));
		
		
		
	}
}

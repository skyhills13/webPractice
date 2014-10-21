package tobyspring.dao.users;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import tobyspring.domain.users.User;


public class UserDaoTest {

	private UserDao dao;
	
	@Before
	public void setUp() {
		ApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext.xml");
		this.dao = applicationContext.getBean("userDao", UserDao.class);		
	}
	
	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException{
		
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
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException, ClassNotFoundException {
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		dao.get("unknown_id");
	}
}

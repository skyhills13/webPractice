package tobyspring.dao.users;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tobyspring.domain.users.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class UserDaoTest {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	private UserDao dao;
	private User user1;
	private User user2;
	private User user3;
	
	@Before
	public void setUp() {
		System.out.println(this.applicationContext);
		System.out.println(this);
		this.dao = this.applicationContext.getBean("userDao", UserDao.class);		
	}
	
	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException{
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		this.user1 = new User("ggyudori", "yoonsungJung","ggg");
		dao.add(user1);
		assertThat(dao.getCount(), is(1));
		
		this.user2 = dao.get(user1.getId());
		assertThat(user2.getName(), is(user1.getName()));
		assertThat(user2.getPassword(), is(user1.getPassword()));
	}
	
	@Test
	public void count() throws SQLException, ClassNotFoundException {
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		this.user1 = new User("dobo", "yoon", "dobopass");
		dao.add(user1);
		assertThat(dao.getCount(), is(1));
		this.user2 = new User("doba", "sung", "dobapass");
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		this.user3 = new User("dodo", "jung", "jungpass");
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

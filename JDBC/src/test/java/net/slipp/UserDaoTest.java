package net.slipp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

public class UserDaoTest {
	@Before
	public void setup() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("user.sql"));
		DatabasePopulatorUtils.execute(populator, DataSourceManager.getDataSource());
	}

	@Test
	public void crud() throws Exception {
		User user = new User("userId", "password", "자바지기", "javajigi@email.com");
		UserDao userDao = new UserDao();
		userDao.insert(user);
		User userFromDb = userDao.findByUserId(user.getUserId());
		assertEquals(user, userFromDb);
		
		User updatedUser = new User("userId", "password", "산지기", "sanjigi@email.com");
		userDao.update(updatedUser);
		userFromDb = userDao.findByUserId(user.getUserId());
		assertEquals(updatedUser, userFromDb);
	}

}

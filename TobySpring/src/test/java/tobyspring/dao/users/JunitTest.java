package tobyspring.dao.users;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContextTest-applicationContext.xml")
public class JunitTest {
	
	@Autowired
	private ApplicationContext applicationContext;

	public static Set<JunitTest> junitTests = new HashSet<JunitTest>();
	private static ApplicationContext contextObject = null;
	
	
	
	@Test
	public void test1() {
		assertThat(junitTests, not(hasItem(this)));
		junitTests.add(this);
		assertThat(contextObject == null || contextObject == this.applicationContext, is(true));
		contextObject = this.applicationContext;
	}
	
	@Test
	public void test2() {
		assertThat(junitTests, not(hasItem(this)));
		junitTests.add(this);
		assertTrue(contextObject == null || contextObject == this.applicationContext);
		contextObject = this.applicationContext;
	}
	
	@Test
	public void test3() {
		assertThat(junitTests, not(hasItem(this)));
		junitTests.add(this);
		assertThat(contextObject, either(is(nullValue())).or(is(this.applicationContext)));
		contextObject = this.applicationContext;
	}
}

package tobyspring.dao.users;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class JunitTest {
	
	public static JunitTest junitTest;
	
	@Test
	public void test1() {
		assertThat(this, is(not(sameInstance(junitTest))));
		junitTest = this;
	}
	
	@Test
	public void test2() {
		assertThat(this, is(not(sameInstance(junitTest))));
		junitTest = this;
	}
	
	@Test
	public void test3() {
		assertThat(this, is(not(sameInstance(junitTest))));
		junitTest = this;
	}

}

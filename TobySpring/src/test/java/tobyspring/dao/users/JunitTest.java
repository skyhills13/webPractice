package tobyspring.dao.users;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


public class JunitTest {
	
	public static Set<JunitTest> junitTests = new HashSet<JunitTest>();
	
	@Test
	public void test1() {
		assertThat(junitTests, not(hasItem(this)));
		junitTests.add(this);
	}
	
	@Test
	public void test2() {
		assertThat(junitTests, not(hasItem(this)));
		junitTests.add(this);
	}
	
	@Test
	public void test3() {
		assertThat(junitTests, not(hasItem(this)));
		junitTests.add(this);
	}
}

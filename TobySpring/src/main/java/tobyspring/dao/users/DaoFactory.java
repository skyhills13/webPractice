package tobyspring.dao.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링이 빈팩토리(빈의 생성과 관계 설정 같은 제어를 담당하는 IoC 오브젝트)를 위한 오브젝트 설정을 담당하는 클래스라고 인식할 수 있도록 추가한 annotation
@Configuration
public class DaoFactory {
	
	@Bean
	public ConnectionMaker connectionMaker(){
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}
	
	@Bean
	public UserDao userDao() {
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;
	}
	
	@Bean
	public UserDao accountDao() {
		return new UserDao(new DConnectionMaker());
	}
	
	@Bean
	public UserDao messageDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}
}

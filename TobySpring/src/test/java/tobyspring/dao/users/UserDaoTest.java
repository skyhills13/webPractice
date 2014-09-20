package tobyspring.dao.users;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import tobyspring.domain.users.User;


public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		//DaoFactory처럼 @Configuration이 붙은 자바 코드를 설정 정보로 사용할때 이용하는 클래스
//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class); 
//		/*getBean()메소드는 applicationContext가 관리하는 오브젝트를 요청하는 메소드
//		 * 첫번째 파라미터는 applicationContext에 등록된 빈의 이름 (=> DaoFactory에서 @Bean이라는 annotation을 userDao라는 이름의 메소드에 붙였는데, 이 메소드의 이름이 바로 빈의 이름
//		 * 즉, DaoFactory의 userDao() 메소드를 호출해서 그 결과를 가져오는 것. 
//		 */
		
		ApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = applicationContext.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("dby");
		user.setName("dbyJung");
		user.setPassword("ehqlehql");
		
		dao.add(user);
		
		System.out.println(user.getId() + " : 등록");
		
		User user2 = dao.get(user.getId());
		
		System.out.println(user2.getName());
		
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " : 조회 성공");
	}
}

package tobyspring.dao.users;

public class DaoFactory {
	
	public ConnectionMaker connectionMaker(){
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}
	
	public UserDao userDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}

	public UserDao accountDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}
	
	public UserDao messageDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}
}

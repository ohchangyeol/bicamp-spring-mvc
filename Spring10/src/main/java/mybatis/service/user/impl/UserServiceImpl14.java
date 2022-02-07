package mybatis.service.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;
import mybatis.service.user.UserDao;
import mybatis.service.user.UserService;

@Service("userServiceImpl14")
public class UserServiceImpl14 implements UserService{
	//field
	@Autowired
	@Qualifier("userDaoImpl14")
	private UserDao userDao;
	
	//consturctor
	public UserServiceImpl14() {
		// TODO Auto-generated constructor stub
		System.out.println("::"+getClass()+"default Constructor Call ....");
	}
	
	
	
	public void setUserDao(UserDao userDao) {
		System.out.println("::"+getClass()+".setUserDao() Call....");
		this.userDao = userDao;
	}
	
	
	
	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		//return userDao.addUser(user);
		
		///////////////////////////////////////////////
		int result = 0;
	      
		System.out.println(">>>>>> 1��° insert=================");
	    result = userDao.addUser(user);
	    System.out.println(">>>>>> 1��° insert=================" + result);
	    System.out.println(">>>>>> 2��° insert=================");
	    result = userDao.addUser(user);
	    System.out.println(">>>>>> 2��° insert=================" + result);
	      
	    System.out.println(">>>>>> �����????====================" );
	      
	    return 0;
		
	}

	@Override
	public User getUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUser(userId);
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public int removeUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.removeUser(userId);
	}

	@Override
	public List<User> getUserList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUserList(search);
	}

}

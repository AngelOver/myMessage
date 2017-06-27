package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserDao;
import domain.User;
@Service("userService")
public class UserService {
	@Resource
	private UserDao userDao;
	public User login(String username, String password)    {
		
		
			User user=null;
				try {
					user=userDao.findByName(username);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		
		if(user!=null)
		{
			if(user.getPassword().equals(password)){
		
				return user;
			}
		}
	
		return null;
	}
	public User register(User user)  {
		// TODO Auto-generated method stub
		try {
			if(userDao.findByName(user.getUsername())==null){
				return userDao.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

package sei.service;

import sei.pojo.User;

public interface UserService {
	public User getUserById(long userId);  
	/**登陆验证**/
	public User validateUser(String userName, String password);
}

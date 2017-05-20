package sei.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import sei.dao.UserMapper;
import sei.pojo.User;
import sei.pojo.UserExample;
import sei.service.UserService;
@Service("userService")
public class UserServiceImpl  implements UserService {
	
	@Resource
	UserMapper userDAO;

	@Override
	public User getUserById(long userId) {
		return this.userDAO.selectByPrimaryKey(userId);

	}

	@Override
	public User validateUser(String userName, String password) {
		UserExample example = new UserExample();
		String enPwd=DigestUtils.md5Hex(password);
		example.createCriteria()
				.andUsernameEqualTo(userName)
				.andPasswordEqualTo(enPwd);
		List<User> list = userDAO.selectByExample(example);
		if(list.isEmpty()) return null;
		return list.get(0);
	}
	

}

package sei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sei.dao.PermissionMapper;
import sei.pojo.Permission;
import sei.pojo.User;
import sei.service.PermissionService;
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
	@Resource
	private PermissionMapper permissionMapper;
	@Override
	public boolean validateUserPermisson(User user, String permissionName) {
		List<Permission> permlist = permissionMapper.selectByUserId(user.getId());
		for(Permission p: permlist){
			if(p.getPermissionName().equals(permissionName))
				return true;
		}
		return false;
	}

}

package sei.service.impl;

import java.util.Set;

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
		Set<Permission> permSet=user.getPermSet();
		Permission p= new Permission();
		p.setPermissionName(permissionName);
		/**能这么用是因为我重写了Permission的equals 和hashCode 方法*/
		if(permSet.contains(p)) return true;
		return false;
	}

}

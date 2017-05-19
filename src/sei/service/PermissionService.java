package sei.service;

import sei.pojo.User;

public interface PermissionService {
	public boolean validateUserPermisson(User user,String permissionName);
}

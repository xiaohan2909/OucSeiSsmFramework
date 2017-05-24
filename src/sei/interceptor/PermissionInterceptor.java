package sei.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import sei.annotation.Permission;
import sei.pojo.User;
import sei.service.PermissionService;

public class PermissionInterceptor implements HandlerInterceptor {
	
	@Resource
	private PermissionService permissionService;
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//处理Permission Annotation，实现方法级权限控制 
		HandlerMethod method = (HandlerMethod)handler;
		//获取方法的注解信息
		Permission permission = method.getMethodAnnotation(Permission.class);
		//null表示该方法不需要特殊权限
		if(permission==null) return true;
		//获取需要的权限
		String permName=permission.permissionName();
		//获取Session  
        HttpSession session = request.getSession();  
        User user = (User)session.getAttribute("user");  
        if(user ==null)  return false;  
        //用户拥有该权限，通过认证
        if(permissionService.validateUserPermisson(user, permName)) return true;
        //没有该权限应该跳转到一个无权限通知的页面
        request.getRequestDispatcher("/WEB-INF/jsp/contents/noPermission.jsp").forward(request, response);  
		return false;
	}

}

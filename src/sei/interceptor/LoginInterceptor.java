package sei.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import sei.pojo.User;

public class LoginInterceptor implements HandlerInterceptor {
	
	/** 
     * Handler执行完成之后调用的方法 
     */  
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
	/** 
     * Handler执行之后，ModelAndView返回之前调用这个方法 
     */ 
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
	}
	/** 
     * Handler执行之前调用这个方法，可以实现登陆拦截
     */  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//获取请求的URL  
        String url = request.getRequestURI();  
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制  
        if(url.endsWith("loginUI.action")|url.endsWith("loginSub.action")){  
            return true;  
        } 
        //获取Session  
        HttpSession session = request.getSession();  
        User user = (User)session.getAttribute("user");  
        if(user != null)  return true;  
        //不符合条件的，跳转到登录界面  
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);  
		return false;
	}

}

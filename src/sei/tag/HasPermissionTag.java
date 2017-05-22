package sei.tag;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;

import sei.pojo.User;
import sei.service.PermissionService;

/** 
 * @author Xiaohan_Li
 * @version 创建时间：2017年5月22日 上午11:12:56 
 */
public class HasPermissionTag extends SimpleTagSupport {
	private static Logger logger = Logger.getLogger(HasPermissionTag.class);  
	/***所需权限*/
	private String needPermission;
	/*@Resource
	private PermissionService permissionService;*/
	

	@Override
	public void doTag() throws JspException, IOException {
		HttpSession session=((PageContext)this.getJspContext()).getSession();
		User user = (User)session.getAttribute("user");
		PermissionService permissionService = ContextLoader.getCurrentWebApplicationContext().getBean(PermissionService.class);
		if(permissionService.validateUserPermisson(user, needPermission)){
			getJspBody().invoke(null);
		}else{
			logger.debug("权限不足，标签隐藏");
		}
	}
	
	public String getNeedPermission() {
		return needPermission;
	}

	public void setNeedPermission(String needPermission) {
		this.needPermission = needPermission;
	}
	
}

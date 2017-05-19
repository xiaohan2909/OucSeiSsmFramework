package sei.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.interceptor.Interceptor;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.MD5Encoder;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sei.annotation.Permission;
import sei.pojo.Product;
import sei.pojo.User;
import sei.service.ProductService;
import sei.service.UserService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author frank
 *
 */
/**
 * @author frank
 *
 */
@Controller  
@RequestMapping("/work")
public class UserController {  
	private static Logger logger = Logger.getLogger(UserController.class);  
    @Resource  
    private UserService userService;  
    @Resource
    private ProductService productService;
      
  /*  @RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model){  
        long userId = Long.parseLong(request.getParameter("id"));  
       User user = userService.getUserById(userId);  
        model.addAttribute("user", user);  
        return "showUser";  
    }  */
    /***
     * 产品列表，顺便测试一下权限注解
     * */
    @RequestMapping("/prolist")
    @Permission(permissionName="product.edit")
    public String productShow(Integer pageCur, String productName,Model model){
    	if(pageCur==null) pageCur=1;
    	PageHelper.startPage(pageCur, 5);
    	List<Product> prolist = productService.listByProductName(productName);
    	@SuppressWarnings({ "rawtypes", "unchecked" })
		PageInfo<Product> page = new PageInfo(prolist);
    	model.addAttribute("page", page);
    	model.addAttribute("productName", productName);
    	logger.info("showPageNum"+page.getPageNum());
    	return "contents/productList";
    }
    /**
     * 显示用户页面示例
     * @return
     */
    @RequestMapping("/userProfile")  
    public ModelAndView wordCountShow(HttpSession session){
    	Map<String,Object> model = new HashMap<String,Object>();  
    	/**从Session里面取User**/
        User user = (User)session.getAttribute("user");
        /**从数据库里刷新一下user的信息**/
        user = userService.getUserById(user.getId());
        model.put("user", user);
        
        /**也可以 return "contents/profile";*/
        return new ModelAndView("contents/profile",model);  
    }
    
	/**
	 * 登陆页
	 * @return
	 */
	@RequestMapping({"/loginUI","loginSub"})
	public String logInAction(String userName,String password,HttpSession session) {
		if(userName==null||password==null) return "login";
		User user = userService.validateUser(userName, password);
		if(user==null) return "login";
		session.setAttribute("user", user);
		return "starter";
	}
    
}  
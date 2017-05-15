package sei.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.interceptor.Interceptor;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.MD5Encoder;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/prolist")
    public String productShow(Integer pageCur, Model model){
    	logger.info("sendMessage");
    	if(pageCur==null) pageCur=1;
    	PageHelper.startPage(pageCur, 5);
    	List<Product> prolist = productService.listProduct();
    	@SuppressWarnings({ "rawtypes", "unchecked" })
		PageInfo<Product> page = new PageInfo(prolist);
    	model.addAttribute("page", page);
    	
    	return "contents/productList";
    }
    /**
     * 显示静态列表示例
     * @return
     */
    @RequestMapping("/staticTable")  
    public String wordCountShow(){
    	return "contents/staticTable";
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
package sei.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sei.pojo.Product;
import sei.service.ProductService;
import sei.service.UserService;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

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
    	List<Product> prolist = productService.listProduct();
    	model.addAttribute("prolist", prolist);
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
     * 主页
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String showHomePage(Model model){
    	return "starter";
    }
}  
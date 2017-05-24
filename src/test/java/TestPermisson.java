package test.java;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sei.pojo.Permission;
import sei.pojo.User;
import sei.service.PermissionService;
import sei.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class TestPermisson {
	 private static Logger logger = Logger.getLogger(TestPermisson.class);  

	    @Resource
	    private PermissionService permissionService;
	    @Resource
	    private UserService userService;
	  
	    @Test  
	    public void test1() {  
	        User u = userService.getUserById(1L);
	        /*Boolean res = permissionService.validateUserPermisson(u, "product.delete");*/
	        Set<Permission> set=u.getPermSet();
	        logger.info(u.getUsername());
	        logger.info("res:"+set);
	    }  
}

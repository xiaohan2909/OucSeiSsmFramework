package test.java;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sei.pojo.User;
import sei.service.PermissionService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class TestPermisson {
	 private static Logger logger = Logger.getLogger(TestPermisson.class);  

	    @Resource
	    private PermissionService permissionService;
	  
	  
	    @Test  
	    public void test1() {  
	        User u = new User();
	        u.setId(2L);
	        Boolean res = permissionService.validateUserPermisson(u, "product.delete");
	        logger.info("res:"+res);
	    }  
}

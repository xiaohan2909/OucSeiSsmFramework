package test.java;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sei.dao.ProductMapper;
import sei.pojo.Product;
import sei.pojo.ProductExample;
import sei.pojo.ProductType;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class TestPageHelper {
	private static Logger logger = Logger.getLogger(TestPageHelper.class);  
	
	@Resource
	private ProductMapper productMapper;
	
	@Test
	public void testPage(){
		logger.info("start Test");
		ProductExample example = new ProductExample();
		example.or().andNameLike("%iPhone%");
		PageHelper.startPage(1, 5);
		List<Product> list = productMapper.selectByExampleWithBLOBs(example);
		PageInfo<Product> page = new PageInfo(list);
		ProductType pt=list.get(0).getProductType();
		logger.info(page.getPages());
	}

}

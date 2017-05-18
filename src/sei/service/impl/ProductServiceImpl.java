package sei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sei.dao.ProductMapper;
import sei.pojo.Product;
import sei.pojo.ProductExample;
import sei.service.ProductService;
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductMapper productMapper;
	@Override
	public List<Product> listByProductName(String productName) {
		ProductExample example=null;
		/**短路操作，安全*/
		if(productName!=null && !productName.trim().isEmpty()){
			example = new ProductExample();
			example.createCriteria().andNameLike("%"+productName+"%");
		}	
		return productMapper.selectByExampleWithBLOBs(example);
	}

}

package sei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sei.dao.ProductMapper;
import sei.pojo.Product;
import sei.service.ProductService;
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductMapper productMapper;
	@Override
	public List<Product> listProduct() {
		// TODO Auto-generated method stub
		return productMapper.selectByExampleWithBLOBs(null);
	}

}

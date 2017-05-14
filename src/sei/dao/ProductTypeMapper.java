package sei.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sei.pojo.ProductType;
import sei.pojo.ProductTypeExample;

public interface ProductTypeMapper {
    int countByExample(ProductTypeExample example);

    int deleteByExample(ProductTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    List<ProductType> selectByExampleWithBLOBs(ProductTypeExample example);

    List<ProductType> selectByExample(ProductTypeExample example);

    ProductType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductType record, @Param("example") ProductTypeExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductType record, @Param("example") ProductTypeExample example);

    int updateByExample(@Param("record") ProductType record, @Param("example") ProductTypeExample example);

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKeyWithBLOBs(ProductType record);

    int updateByPrimaryKey(ProductType record);
}
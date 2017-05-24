package sei.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import sei.pojo.Permission;
import sei.pojo.PermissionExample;

public interface PermissionMapper {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    //根据用户Id获取权限信息
    Set<Permission> selectByUserId(@Param("uid") Long uid);
}
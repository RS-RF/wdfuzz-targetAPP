package com.example.demo.mapper;

import com.example.demo.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface SysUserMapper {
    List<SysUser> selectAll();
    SysUser selectById(Integer userId);
    List<SysUser> searchUsers(@Param("keyword") String keyword);  // 存在注入的方法
    int insert(SysUser user);
    int update(SysUser user);
    int delete(Integer userId);
}
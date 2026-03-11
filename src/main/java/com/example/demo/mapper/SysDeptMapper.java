package com.example.demo.mapper;

import com.example.demo.entity.SysDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysDeptMapper {
    void updateDept(SysDept dept);
    List<SysDept> selectAll();
}

package com.example.demo.controller;

import com.example.demo.entity.SysDept;
import com.example.demo.mapper.SysDeptMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/dept")
public class DeptController {

    @Autowired
    private SysDeptMapper deptMapper;

    @GetMapping
    public List<SysDept> list() {
        return deptMapper.selectAll();
    }

    @PostMapping("/edit")
    public String edit(@Validated @RequestBody SysDept dept) {
        // 模拟静态分析中提取的脆弱路径：参数 dept 流向 deptMapper.updateDept
        if ("open".equals(dept.getStatus())) {
            updateDeptStatus(dept);
        }
        return "processed";
    }

    private void updateDeptStatus(SysDept dept) {
        String actionStr = (String) dept.getParams().get("action");
        Map<String, Object> action = JSONObject.parseObject(actionStr);
        if (Boolean.TRUE.equals(action.get("modify"))) {
            deptMapper.updateDept(dept);  // sink 点
        }
    }
}
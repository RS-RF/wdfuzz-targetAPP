package com.example.demo.controller;

import com.example.demo.entity.SysUser;
import com.example.demo.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private SysUserMapper userMapper;

    @GetMapping
    public List<SysUser> list() {
        return userMapper.selectAll();
    }

    // 存在 SQL 注入的搜索接口
    @GetMapping("/search")
    public List<SysUser> search(@RequestParam String keyword) {
        return userMapper.searchUsers(keyword);
    }

    @PostMapping
    public SysUser create(@RequestBody SysUser user) {
        userMapper.insert(user);
        return user;
    }

    @PutMapping("/{id}")
    public SysUser update(@PathVariable Integer id, @RequestBody SysUser user) {
        user.setUserId(id);
        userMapper.update(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userMapper.delete(id);
    }
}
package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.Map;

public class SysDept {
    private Long deptId;
    private String deptName;
    @Email
    private String email;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;
    private Map<String, Object> params;  // 用于传递额外参数
    // getters and setters (省略，请自行生成)

    // getters and setters
    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName(){
        return deptName;
    }

    public void setDeptName(String deptName){
        this.deptName = deptName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
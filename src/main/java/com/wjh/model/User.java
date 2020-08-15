package com.wjh.model;


import com.wjh.annotation.MyField;
import com.wjh.annotation.MyTable;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
@MyTable(value = "user")
public class User {

  private int id;
  private String username;
  private String password;
  private String email;
  @MyField("qq_openid")
  private String qqOpenid;
  @MyField("wx_openid")
  private String wxOpenid;
  @MyField("real_name")
  private String realName;
  private Integer age;
  private String phone;
  private String gender;
  private String desc;
  @MyField("register_time")
  private Date registerTime;
  @MyField("login_time")
  private Date loginTime;
  private String pic;
  private Integer look;
  @MyField("is_secret")
  private String isSecret;
  @MyField("dept_name")
  private String deptName;
  @MyField("dept_id")
  private Integer deptId;
  public User() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getQqOpenid() {
    return qqOpenid;
  }

  public void setQqOpenid(String qqOpenid) {
    this.qqOpenid = qqOpenid;
  }

  public String getWxOpenid() {
    return wxOpenid;
  }

  public void setWxOpenid(String wxOpenid) {
    this.wxOpenid = wxOpenid;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Date getRegisterTime() {
    return registerTime;
  }

  public void setRegisterTime(Date registerTime) {
    this.registerTime = registerTime;
  }

  public Date getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(Date loginTime) {
    this.loginTime = loginTime;
  }

  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }

  public Integer getLook() {
    return look;
  }

  public void setLook(Integer look) {
    this.look = look;
  }

  public String getIsSecret() {
    return isSecret;
  }

  public void setIsSecret(String isSecret) {
    this.isSecret = isSecret;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public Integer getDeptId() {
    return deptId;
  }

  public void setDeptId(Integer deptId) {
    this.deptId = deptId;
  }
}

package com.wjh.model;


import com.wjh.annotation.MyTable;

import java.util.ArrayList;
import java.util.List;
@MyTable("dept")
public class Dept {

  private int id;
  private String name;
  private List<User> userList=new ArrayList<>(0);
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }
}

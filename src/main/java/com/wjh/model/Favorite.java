package com.wjh.model;

import com.wjh.annotation.MyField;
import com.wjh.annotation.MyTable;

@MyTable(value = "favorite",KeyName = "u_id")
public class Favorite {
@MyField("u_id")
  private int uId;
@MyField("a_id")
  private int aId;


  public int getuId() {
    return uId;
  }

  public void setuId(int uId) {
    this.uId = uId;
  }

  public int getaId() {
    return aId;
  }

  public void setaId(int aId) {
    this.aId = aId;
  }
}

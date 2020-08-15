package com.wjh.model;

import com.wjh.annotation.MyField;
import com.wjh.annotation.MyTable;

@MyTable(value = "meeting_join",KeyName = "u_id")
public class MeetingJoin {
@MyField("u_id")
  private int uId;
@MyField("c_id")
  private int cId;


  public int getuId() {
    return uId;
  }

  public void setuId(int uId) {
    this.uId = uId;
  }

  public int getcId() {
    return cId;
  }

  public void setcId(int cId) {
    this.cId = cId;
  }
}

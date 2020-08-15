package com.wjh.model;

import com.wjh.annotation.MyField;
import com.wjh.annotation.MyTable;

@MyTable("userforcus")
public class Userfocus {
@MyField("user_id")
  private int userId;
@MyField("user_focus_id")
  private int userFocusId;


  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getUserFocusId() {
    return userFocusId;
  }

  public void setUserFocusId(int userFocusId) {
    this.userFocusId = userFocusId;
  }
}

package com.wjh.model;


import com.wjh.annotation.MyField;
import com.wjh.annotation.MyTable;

import java.util.Date;
@MyTable("meeting")
public class Meeting {

  private int id;
  @MyField("dept_name")
  private String deptName;
  @MyField("dept_id")
  private int deptId;
  private String title;
  private String content;
  @MyField("publish_date")
  private Date publishDate;
  @MyField("start_time")
  private Date startTime;
  @MyField("end_time")
  private Date endTime;
  private int status;
  @MyField("make_user")
  private String makeUser;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public int getDeptId() {
    return deptId;
  }

  public void setDeptId(int deptId) {
    this.deptId = deptId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMakeUser() {
    return makeUser;
  }

  public void setMakeUser(String makeUser) {
    this.makeUser = makeUser;
  }
}

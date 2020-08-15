package com.wjh.model;
import com.wjh.annotation.MyField;
import com.wjh.annotation.MyTable;

import java.util.Date;
@MyTable("article")
public class Article {

  private int id;
  private String title;
  private String content;
  @MyField("browse_count")
  private int browseCount;
  @MyField("publish_date")
  private Date publishDate;
  @MyField("publish_real_name")
  private String publishRealName;
  @MyField("user_id")
  private int userId;
  private User user = new User();
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public int getBrowseCount() {
    return browseCount;
  }

  public void setBrowseCount(int browseCount) {
    this.browseCount = browseCount;
  }

  public Date getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  public String getPublishRealName() {
    return publishRealName;
  }

  public void setPublishRealName(String publishRealName) {
    this.publishRealName = publishRealName;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}

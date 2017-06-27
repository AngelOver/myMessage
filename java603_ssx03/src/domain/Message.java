package domain;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
	  private String id;
	  private String content;
	  private String createTime;
	  
	  private User user;
	  private Theme theme;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", createTime="
				+ createTime + ", user=" + user + ", theme=" + theme.getTitle() + "]";
	}
	  
	  
}

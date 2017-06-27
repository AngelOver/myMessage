package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class Theme implements Serializable{
	  private String id;
	  private String title;
	  private String content;
	  private String createTime;
	  
	  private User user;
	  private List<Message> Messages;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public List<Message> getMessages() {
		return Messages;
	}
	public void setMessages(List<Message> messages) {
		Messages = messages;
	}
	@Override
	public String toString() {
		return "Theme [id=" + id + ", title=" + title + ", content=" + content
				+ ", user=" + user + "]";
	}
	  
	  
	  
	  

}

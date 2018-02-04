package wechat.com.dao.pojo;

import java.io.Serializable;
import java.util.Date;

public class DBPublicBBSMessageRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1682984744177680383L;
	
	private Long id;
	private DBUser user;
	private String message;
	private Date speakAt;
	private Integer sensitive;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DBUser getUser() {
		return user;
	}
	public void setUser(DBUser user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSpeakAt() {
		return speakAt;
	}
	public void setSpeakAt(Date speakAt) {
		this.speakAt = speakAt;
	}
	public Integer getSensitive() {
		return sensitive;
	}
	public void setSensitive(Integer sensitive) {
		this.sensitive = sensitive;
	}
}

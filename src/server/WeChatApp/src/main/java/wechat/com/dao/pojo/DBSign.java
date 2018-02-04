package wechat.com.dao.pojo;

import java.io.Serializable;
import java.util.Date;

public class DBSign implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1263370192026718748L;
	
	private Long id;
	private DBUser user;
	private Date signAt;
	
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
	public Date getSignAt() {
		return signAt;
	}
	public void setSignAt(Date signAt) {
		this.signAt = signAt;
	}
}

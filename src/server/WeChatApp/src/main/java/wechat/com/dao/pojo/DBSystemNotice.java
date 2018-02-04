package wechat.com.dao.pojo;

import java.io.Serializable;
import java.util.Date;

public class DBSystemNotice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6353020549313926502L;
	
	private Integer id;
	private String content;
	private Date createAt;
	private Date releaseAt;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getReleaseAt() {
		return releaseAt;
	}
	public void setReleaseAt(Date releaseAt) {
		this.releaseAt = releaseAt;
	}

}

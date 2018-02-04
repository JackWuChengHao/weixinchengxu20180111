package wechat.com.dao.pojo;

import java.io.Serializable;
import java.util.Date;

public class DBArticle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8467464661095402588L;
	
	private Integer id;
	private String brief;
	private String details;
	private Date createAt;
	private String releasePlace;
	private String briefInfo;
	private String articleGroup;
	private String articleIndex;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public String getReleasePlace() {
		return releasePlace;
	}
	public void setReleasePlace(String releasePlace) {
		this.releasePlace = releasePlace;
	}
	public String getBriefInfo() {
		return briefInfo;
	}
	public void setBriefInfo(String briefInfo) {
		this.briefInfo = briefInfo;
	}
	public String getArticleGroup() {
		return articleGroup;
	}
	public void setArticleGroup(String articleGroup) {
		this.articleGroup = articleGroup;
	}
	public String getArticleIndex() {
		return articleIndex;
	}
	public void setArticleIndex(String articleIndex) {
		this.articleIndex = articleIndex;
	}
}

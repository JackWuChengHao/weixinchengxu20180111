package wechat.com.dao.pojo;

import java.io.Serializable;
import java.util.Date;

public class DBQuestion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6009098749312474322L;

	private Long id;
	private DBUser questioner;
	private String content;
	private Date createAt;
	private Long questionerContactInfo;
	private Integer pay;
	private String answerWay;
	private String state;
	private Date answerAt;
	private DBUser answer;
	private String releasePlace;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DBUser getQuestioner() {
		return questioner;
	}
	public void setQuestioner(DBUser questioner) {
		this.questioner = questioner;
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
	public Long getQuestionerContactInfo() {
		return questionerContactInfo;
	}
	public void setQuestionerContactInfo(Long questionerContactInfo) {
		this.questionerContactInfo = questionerContactInfo;
	}
	public Integer getPay() {
		return pay;
	}
	public void setPay(Integer pay) {
		this.pay = pay;
	}
	public String getAnswerWay() {
		return answerWay;
	}
	public void setAnswerWay(String answerWay) {
		this.answerWay = answerWay;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getAnswerAt() {
		return answerAt;
	}
	public void setAnswerAt(Date answerAt) {
		this.answerAt = answerAt;
	}
	public DBUser getAnswer() {
		return answer;
	}
	public void setAnswer(DBUser answer) {
		this.answer = answer;
	}
	public String getReleasePlace() {
		return releasePlace;
	}
	public void setReleasePlace(String releasePlace) {
		this.releasePlace = releasePlace;
	}
}

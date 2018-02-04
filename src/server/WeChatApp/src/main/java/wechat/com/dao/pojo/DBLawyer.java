package wechat.com.dao.pojo;

import java.io.Serializable;

public class DBLawyer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8354599459527822890L;

	private Integer id;
	private String lawOffice;
	private String name;
	private Long phone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLawOffice() {
		return lawOffice;
	}
	public void setLawOffice(String lawOffice) {
		this.lawOffice = lawOffice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
}

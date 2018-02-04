package wechat.com.dao.pojo;

import java.io.Serializable;

public class DBTeacher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2399957823041883378L;
	
	private Integer id;
	private String school;
	private String name;
	private Long phone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
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

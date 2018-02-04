package wechat.com.dao.pojo;

import java.io.Serializable;
import java.util.Date;

public class DBUser implements Serializable {

	/**
	 * 用户
	 */
	private static final long serialVersionUID = -3943664468915690225L;
	
	private Long id;
	private String wechatAccount;
	private String photoGroup;
	private String photoIndex;
	private String nickname;
	private Long mobilephone;
	private String name;
	private String province;
	private String city;
	private String county;
	private String addr;
	private Long permission;
	private Integer status;
	private Long integral;//签到积分
	private Date lastLogin;
	private Integer gag;//是否禁言
	private Integer banner;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWechatAccount() {
		return wechatAccount;
	}
	public void setWechatAccount(String wechatAccount) {
		this.wechatAccount = wechatAccount;
	}
	public String getPhotoGroup() {
		return photoGroup;
	}
	public void setPhotoGroup(String photoGroup) {
		this.photoGroup = photoGroup;
	}
	public String getPhotoIndex() {
		return photoIndex;
	}
	public void setPhotoIndex(String photoIndex) {
		this.photoIndex = photoIndex;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Long getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(Long mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Long getPermission() {
		return permission;
	}
	public void setPermission(Long permission) {
		this.permission = permission;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getIntegral() {
		return integral;
	}
	public void setIntegral(Long integral) {
		this.integral = integral;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Integer getGag() {
		return gag;
	}
	public void setGag(Integer gag) {
		this.gag = gag;
	}
	public Integer getBanner() {
		return banner;
	}
	public void setBanner(Integer banner) {
		this.banner = banner;
	}
}

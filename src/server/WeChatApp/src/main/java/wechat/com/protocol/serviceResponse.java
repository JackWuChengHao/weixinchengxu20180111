package wechat.com.protocol;

import wechat.com.common.errorCodeEnum;

public class serviceResponse {
	private errorCodeEnum errCode;
	private Object object;
	
	public serviceResponse() {
		// TODO Auto-generated constructor stub
	}
	public serviceResponse(errorCodeEnum errCode) {
		this.errCode = errCode;

	}
	public errorCodeEnum getErrCode() {
		return errCode;
	}
	public void setErrCode(errorCodeEnum errCode) {
		this.errCode = errCode;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
}

package wechat.com.common;

public enum errorCodeEnum {
	SUCCESS(0, "成功"),
	SERVICE_ERR(1, "业务异常"),
	UNKNOW_SIGNER(2, "未知签到者"),
	RE_SIGN(3, "您已经签过到了"),
	RELEASE_LOCATION(4, "请选择发布位置"),
	UNKNOW_ARTICLE(5, "未知文章编号"),
	RE_RELEASE(6, "请勿重复发布"),
	UNKNOW_LOCATION(7, "未知发布地点"),
	UNKNOW_QUESTIONER(8, "未知提问者"),
	NULL_QUESTION(9, "空问题"),
	UNKNOW_QUESTION(10, "未知问题"),
	FINISHED_NONEED(11, "已解答，无需付款");
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private int code;
	private String msg;
	
	private errorCodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}

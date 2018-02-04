package wechat.com.common;

public enum answerWayEnum {
	WRITTEN(1, "文字"),
	PHONE(2, "电话"),
	OTHER(3, "其他");
	
	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	private int code;
	private String msg;
	
	private answerWayEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}

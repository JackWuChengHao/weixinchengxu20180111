package wechat.com.common;

public enum questionStateEnum {
	SUBMIT(1, "已提交处理"),
	DEALWITH(2, "正在处理"),
	FINISH(3, "处理完毕");
	
	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	private int code;
	private String msg;
	
	private questionStateEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}

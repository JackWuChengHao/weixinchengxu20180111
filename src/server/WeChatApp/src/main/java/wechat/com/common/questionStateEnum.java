package wechat.com.common;

public enum questionStateEnum {
	SUBMIT(1, "���ύ����"),
	DEALWITH(2, "���ڴ���"),
	FINISH(3, "�������");
	
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

package wechat.com.common;

public enum errorCodeEnum {
	SUCCESS(0, "�ɹ�"),
	SERVICE_ERR(1, "ҵ���쳣"),
	UNKNOW_SIGNER(2, "δ֪ǩ����"),
	RE_SIGN(3, "���Ѿ�ǩ������"),
	RELEASE_LOCATION(4, "��ѡ�񷢲�λ��"),
	UNKNOW_ARTICLE(5, "δ֪���±��"),
	RE_RELEASE(6, "�����ظ�����"),
	UNKNOW_LOCATION(7, "δ֪�����ص�"),
	UNKNOW_QUESTIONER(8, "δ֪������"),
	NULL_QUESTION(9, "������"),
	UNKNOW_QUESTION(10, "δ֪����"),
	FINISHED_NONEED(11, "�ѽ�����踶��");
	
	
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

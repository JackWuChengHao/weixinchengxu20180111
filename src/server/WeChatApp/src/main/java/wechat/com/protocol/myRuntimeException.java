package wechat.com.protocol;

public class myRuntimeException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5229903265225459336L;

	public myRuntimeException(String message) {
		 super(message);
	}
	
	public myRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}

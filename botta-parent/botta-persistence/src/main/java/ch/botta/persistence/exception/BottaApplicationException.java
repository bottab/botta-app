package ch.botta.persistence.exception;

public class BottaApplicationException extends Exception{

	public BottaApplicationException() {}
	
	public BottaApplicationException(String message) {
		super(message);
	}
	
	public BottaApplicationException(Throwable cause) {
		super(cause);
	}
	
	public BottaApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BottaApplicationException(String message, Throwable cause,boolean enableSuppression, boolean writableStackTrace){
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}

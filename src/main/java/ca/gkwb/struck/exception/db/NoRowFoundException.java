package ca.gkwb.struck.exception.db;

public class NoRowFoundException extends Exception {
	  public NoRowFoundException() { super(); }
	  public NoRowFoundException(String message) { super(message); }
	  public NoRowFoundException(String message, Throwable cause) { super(message, cause); }
	  public NoRowFoundException(Throwable cause) { super(cause); }	

}

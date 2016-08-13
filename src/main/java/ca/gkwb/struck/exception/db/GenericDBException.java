package ca.gkwb.struck.exception.db;

public class GenericDBException extends Exception {
	  public GenericDBException() { super(); }
	  public GenericDBException(String message) { super(message); }
	  public GenericDBException(String message, Throwable cause) { super(message, cause); }
	  public GenericDBException(Throwable cause) { super(cause); }	
}

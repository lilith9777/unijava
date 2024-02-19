package exception;

public class CountryApiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CountryApiException() {
		super();
	}

	public CountryApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CountryApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public CountryApiException(String message) {
		super(message);
	}

	public CountryApiException(Throwable cause) {
		super(cause);
	}

}

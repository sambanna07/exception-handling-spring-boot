package com.exceptionhandler.exception;

public class EmptyInputException extends RuntimeException {

    /**
	 * Handle empty input exception.
	 */
	private static final long serialVersionUID = 1L;

	private int errorCode;
    private String errorMessage;

    /**
     * Constructs an EmptyInputException with no specified detail message.
     */
    public EmptyInputException() {
    	
    }

    /**
     * Constructs an EmptyInputException with the specified error code and error message.
     *
     * @param errorCode    the error code associated with the exception
     * @param errorMessage the error message associated with the exception
     */
    public EmptyInputException(int errorCode, String errorMessage) {
        super();
        this.setErrorCode(errorCode);
        this.setErrorMessage(errorMessage);
    }

    /**
     * Gets the error code associated with the exception.
     *
     * @return the error code
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the error code associated with the exception.
     *
     * @param errorCode the error code to set
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets the error message associated with the exception.
     *
     * @return the error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the error message associated with the exception.
     *
     * @param errorMessage the error message to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

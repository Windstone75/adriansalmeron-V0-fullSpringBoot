package com.asf.bricotuto.model.exception;

public class UserAlreadyExistException extends Exception { 

	private static final long serialVersionUID = -4958740062171398678L;

	/**
     * @param pMessage -
     */
    public UserAlreadyExistException(String pMessage) {
        super(pMessage);
    }


    /**
     * @param pMessage -
     * @param pCause -
     */
    public UserAlreadyExistException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}

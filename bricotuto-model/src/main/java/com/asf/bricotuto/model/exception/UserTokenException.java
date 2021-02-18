package com.asf.bricotuto.model.exception;

public class UserTokenException  extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7944816568803947502L;


	/**
     * Constructeur.
     *
     * @param pMessage -
     */
    public UserTokenException(String pMessage) {
        super(pMessage);
    }


    /**
     * Constructeur.
     *
     * @param pMessage -
     * @param pCause -
     */
    public UserTokenException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}

package com.asf.bricotuto.model.exception;

/**
 * Classe d'exception levée quand une erreur technique est survenue
 *
 * @author lgu
 */
public class FunctionalException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4958740062171398678L;


	/**
     * Constructeur.
     *
     * @param pMessage -
     */
    public FunctionalException(String pMessage) {
        super(pMessage);
    }


    /**
     * Constructeur.
     *
     * @param pMessage -
     * @param pCause -
     */
    public FunctionalException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}

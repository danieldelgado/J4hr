package com.j4hr.app.joboffer.server.service.exception;

/**
 * Exception correspondant à un problème rencontré au niveau de la couche service
 * @author fabricesznajderman
 *
 */
public class ServiceException extends Exception {

	public ServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}

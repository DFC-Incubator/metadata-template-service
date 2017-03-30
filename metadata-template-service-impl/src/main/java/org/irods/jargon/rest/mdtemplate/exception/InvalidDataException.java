/**
 *
 */
package org.irods.jargon.rest.mdtemplate.exception;

/**
 * Invalid data in rest request
 *
 * @author mconway
 *
 */
public class InvalidDataException extends MetadataTemplateException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public InvalidDataException(final String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidDataException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public InvalidDataException(final Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param underlyingIRODSExceptionCode
	 */
	public InvalidDataException(final String message, final Throwable cause, final int underlyingIRODSExceptionCode) {
		super(message, cause, underlyingIRODSExceptionCode);
	}

	/**
	 * @param cause
	 * @param underlyingIRODSExceptionCode
	 */
	public InvalidDataException(final Throwable cause, final int underlyingIRODSExceptionCode) {
		super(cause, underlyingIRODSExceptionCode);
	}

	/**
	 * @param message
	 * @param underlyingIRODSExceptionCode
	 */
	public InvalidDataException(final String message, final int underlyingIRODSExceptionCode) {
		super(message, underlyingIRODSExceptionCode);
	}

}

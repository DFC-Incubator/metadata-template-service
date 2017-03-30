/**
 *
 */
package org.irods.jargon.rest.mdtemplate.exception;

import org.irods.jargon.core.exception.JargonException;

/**
 * Top level metadata template rest layer exception
 *
 * @author mconway
 *
 */
public class MetadataTemplateException extends JargonException {

	/**
	 *
	 */
	private static final long serialVersionUID = -3812489644397296843L;

	/**
	 * @param message
	 */
	public MetadataTemplateException(final String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MetadataTemplateException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public MetadataTemplateException(final Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param underlyingIRODSExceptionCode
	 */
	public MetadataTemplateException(final String message, final Throwable cause,
			final int underlyingIRODSExceptionCode) {
		super(message, cause, underlyingIRODSExceptionCode);
	}

	/**
	 * @param cause
	 * @param underlyingIRODSExceptionCode
	 */
	public MetadataTemplateException(final Throwable cause, final int underlyingIRODSExceptionCode) {
		super(cause, underlyingIRODSExceptionCode);
	}

	/**
	 * @param message
	 * @param underlyingIRODSExceptionCode
	 */
	public MetadataTemplateException(final String message, final int underlyingIRODSExceptionCode) {
		super(message, underlyingIRODSExceptionCode);
	}

}

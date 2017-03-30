package org.irods.jargon.rest.mdtemplate;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2017-02-10T11:41:28.008-05:00")
public class ApiException extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = -8111372944448999126L;
	private int code;

	public ApiException(final int code, final String msg) {
		super(msg);
		this.code = code;
	}
}

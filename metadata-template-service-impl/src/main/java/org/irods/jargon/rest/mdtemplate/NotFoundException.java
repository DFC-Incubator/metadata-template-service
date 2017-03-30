package org.irods.jargon.rest.mdtemplate;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2017-02-10T11:41:28.008-05:00")
public class NotFoundException extends ApiException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1069257573068210467L;
	private int code;

	public NotFoundException(final int code, final String msg) {
		super(code, msg);
		this.code = code;
	}
}

/**
 * 
 */
package org.irods.jargon.rest.mdtemplate;

import org.irods.jargon.core.connection.IRODSAccount;

/**
 * Context for file based (dot irods file storge) of metadata templates
 * 
 * @author mconway
 *
 */
public class FileBasedTemplateContext {

	private IRODSAccount irodsAccount;

	/**
	 * 
	 */
	public FileBasedTemplateContext() {
	}

	public IRODSAccount getIrodsAccount() {
		return irodsAccount;
	}

	public void setIrodsAccount(IRODSAccount irodsAccount) {
		this.irodsAccount = irodsAccount;
	}

}

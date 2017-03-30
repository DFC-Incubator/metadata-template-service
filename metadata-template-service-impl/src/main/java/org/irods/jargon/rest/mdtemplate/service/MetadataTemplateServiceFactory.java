package org.irods.jargon.rest.mdtemplate.service;

import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.metadatatemplate.AbstractMetadataResolver;
import org.irods.jargon.metadatatemplate.MetadataTemplateProcessingException;

/**
 * Factory for metadata template services. This enhances the ability to plug in
 * new implementations in an easily testable manner
 * 
 * @author mconway
 *
 * @param <T>
 *            {@link TemplateSourceContext} subclass that can pass
 *            implementation-specific credentials and configuration to the
 *            template service
 */
public interface MetadataTemplateServiceFactory<T extends TemplateSourceContext> {

	/**
	 * Obtain the metadata resolver that can locate and process templates
	 * 
	 * @param irodsAccount
	 *            {@link IRODSAccount} with iRODS login information
	 * @param templateSourceContext
	 *            optional {@link TemplateSourceContext} with implementation
	 *            specific information, can be set to null if not used
	 * @return {@link AbstractMetadataResolver}
	 * @throws MetadataTemplateProcessingException
	 */
	AbstractMetadataResolver instanceMetadataResolver(IRODSAccount irodsAccount, T templateSourceContext)
			throws MetadataTemplateProcessingException;

}
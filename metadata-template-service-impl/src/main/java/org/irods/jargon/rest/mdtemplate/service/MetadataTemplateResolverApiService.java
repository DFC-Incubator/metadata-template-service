/**
 * 
 */
package org.irods.jargon.rest.mdtemplate.service;

import org.irods.jargon.core.pub.IRODSAccessObjectFactory;
import org.irods.jargon.metadatatemplate.AbstractMetadataResolver;
import org.irods.jargon.metadatatemplate.MetadataTemplateProcessingException;
import org.irods.jargon.rest.mdtemplate.model.MetadataTemplateList;
import org.irods.jargon.rest.mdtemplate.model.utils.TemplateModelTransformer;
import org.irods.jargon.rest.security.IrodsAuthentication;
import org.irods.jargon.rest.security.SecurityContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service facade for metadata template resolver
 * 
 * @author mconway
 *
 */
public class MetadataTemplateResolverApiService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * Access object factory from base Jargon
	 */
	@Autowired
	private IRODSAccessObjectFactory irodsAccessObjectFactory;

	/**
	 * Factory service to create appropriate metadata template services
	 */
	@Autowired
	private MetadataTemplateServiceFactory<TemplateSourceContext> metadataTemplateServiceFactory;

	public MetadataTemplateList listPublicTemplates() throws MetadataTemplateProcessingException {
		log.info("listPublicTemplates()");
		IrodsAuthentication irodsAuthentication = SecurityContextHelper.obtainIrodsAuthenticationFromContext();
		AbstractMetadataResolver resolver = metadataTemplateServiceFactory
				.instanceMetadataResolver(irodsAuthentication.getIrodsAccount(), null);
		return TemplateModelTransformer.restMetadataTemplateListFromBaseModel(resolver.listPublicTemplates());

	}

	public MetadataTemplateServiceFactory<TemplateSourceContext> getMetadataTemplateServiceFactory() {
		return metadataTemplateServiceFactory;
	}

	public void setMetadataTemplateServiceFactory(
			MetadataTemplateServiceFactory<TemplateSourceContext> metadataTemplateServiceFactory) {
		this.metadataTemplateServiceFactory = metadataTemplateServiceFactory;
	}

	public IRODSAccessObjectFactory getIrodsAccessObjectFactory() {
		return irodsAccessObjectFactory;
	}

	public void setIrodsAccessObjectFactory(IRODSAccessObjectFactory irodsAccessObjectFactory) {
		this.irodsAccessObjectFactory = irodsAccessObjectFactory;
	}

}

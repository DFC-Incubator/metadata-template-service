/**
 *
 */
package org.irods.jargon.rest.mdtemplate.service;

import org.irods.jargon.core.pub.IRODSAccessObjectFactory;
import org.irods.jargon.metadatatemplate.AbstractMetadataResolver;
import org.irods.jargon.metadatatemplate.MetadataTemplateProcessingException;
import org.irods.jargon.rest.mdtemplate.exception.MetadataTemplateException;
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

	/**
	 * Hook for obtaining security context info
	 */
	@Autowired
	private SecurityContextHelper securityContextHelper;

	public MetadataTemplateList listPublicTemplates()
			throws MetadataTemplateException, MetadataTemplateProcessingException {
		log.info("listPublicTemplates()");
		IrodsAuthentication irodsAuthentication = securityContextHelper.obtainIrodsAuthenticationFromContext();
		AbstractMetadataResolver resolver = metadataTemplateServiceFactory
				.instanceMetadataResolver(irodsAuthentication.getIrodsAccount(), null);
		return TemplateModelTransformer.restMetadataTemplateListFromBaseModel(resolver.listPublicTemplates());

	}

	public MetadataTemplateServiceFactory<TemplateSourceContext> getMetadataTemplateServiceFactory() {
		return metadataTemplateServiceFactory;
	}

	public void setMetadataTemplateServiceFactory(
			final MetadataTemplateServiceFactory<TemplateSourceContext> metadataTemplateServiceFactory) {
		this.metadataTemplateServiceFactory = metadataTemplateServiceFactory;
	}

	public IRODSAccessObjectFactory getIrodsAccessObjectFactory() {
		return irodsAccessObjectFactory;
	}

	public void setIrodsAccessObjectFactory(final IRODSAccessObjectFactory irodsAccessObjectFactory) {
		this.irodsAccessObjectFactory = irodsAccessObjectFactory;
	}

	public SecurityContextHelper getSecurityContextHelper() {
		return securityContextHelper;
	}

	public void setSecurityContextHelper(final SecurityContextHelper securityContextHelper) {
		this.securityContextHelper = securityContextHelper;
	}

}

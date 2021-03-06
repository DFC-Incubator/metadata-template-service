/**
 *
 */
package org.irods.jargon.rest.mdtemplate.service;

import java.util.UUID;

import org.irods.jargon.core.pub.IRODSAccessObjectFactory;
import org.irods.jargon.metadatatemplate.AbstractMetadataResolver;
import org.irods.jargon.metadatatemplate.MetadataTemplateContext;
import org.irods.jargon.metadatatemplate.MetadataTemplateLocationTypeEnum;
import org.irods.jargon.metadatatemplate.MetadataTemplateProcessingException;
import org.irods.jargon.metadatatemplate.MetadataTemplateServiceFactory;
import org.irods.jargon.rest.mdtemplate.exception.MetadataTemplateException;
import org.irods.jargon.rest.mdtemplate.model.MetadataTemplateList;
import org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate;
import org.irods.jargon.rest.mdtemplate.model.utils.TemplateModelTransformer;
import org.irods.jargon.rest.security.IrodsAuthentication;
import org.irods.jargon.rest.security.SecurityContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service facade for metadata template resolver
 *
 * @author mconway
 *
 */
@Component
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
	private MetadataTemplateServiceFactory<MetadataTemplateContext> metadataTemplateServiceFactory;

	/**
	 * Hook for obtaining security context info
	 */
	@Autowired
	private SecurityContextHelper securityContextHelper;

	public MetadataTemplateList listPublicTemplates()
			throws MetadataTemplateException, MetadataTemplateProcessingException {
		log.info("listPublicTemplates()");
		MetadataTemplateContext context = buildContext();
		AbstractMetadataResolver<MetadataTemplateContext> resolver = metadataTemplateServiceFactory
				.instanceMetadataResolver(context);
		return TemplateModelTransformer.restMetadataTemplateListFromBaseModel(resolver.listPublicTemplates());

	}

	private MetadataTemplateContext buildContext() {
		IrodsAuthentication irodsAuthentication = securityContextHelper.obtainIrodsAuthenticationFromContext();

		MetadataTemplateContext context = new MetadataTemplateContext();
		context.setIrodsAccount(irodsAuthentication.getIrodsAccount());
		return context;
	}

	public UUID savePublicTemplate(RestMetadataTemplate restMetadataTemplate)
			throws MetadataTemplateException, MetadataTemplateProcessingException {
		log.info("savePublicTemplate()");
		MetadataTemplateContext context = buildContext();
		AbstractMetadataResolver<MetadataTemplateContext> resolver = metadataTemplateServiceFactory
				.instanceMetadataResolver(context);
		return resolver.saveTemplate(TemplateModelTransformer.baseMetadataTemplateFromRestModel(restMetadataTemplate),
				MetadataTemplateLocationTypeEnum.PUBLIC);

	}

	public MetadataTemplateServiceFactory<MetadataTemplateContext> getMetadataTemplateServiceFactory() {
		return metadataTemplateServiceFactory;
	}

	public void setMetadataTemplateServiceFactory(
			final MetadataTemplateServiceFactory<MetadataTemplateContext> metadataTemplateServiceFactory) {
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

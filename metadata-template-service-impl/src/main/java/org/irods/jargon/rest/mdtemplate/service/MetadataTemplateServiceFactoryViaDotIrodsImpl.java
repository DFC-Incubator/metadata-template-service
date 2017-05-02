/**
 *
 */
package org.irods.jargon.rest.mdtemplate.service;

import org.irods.jargon.core.pub.IRODSAccessObjectFactory;
import org.irods.jargon.metadatatemplate.AbstractMetadataResolver;
import org.irods.jargon.metadatatemplate.JargonMetadataResolver;
import org.irods.jargon.metadatatemplate.MetadataTemplateConfiguration;
import org.irods.jargon.metadatatemplate.MetadataTemplateContext;
import org.irods.jargon.metadatatemplate.MetadataTemplateProcessingException;
import org.irods.jargon.metadatatemplate.MetadataTemplateServiceFactory;
import org.irods.jargon.rest.mdtemplate.config.MetadataTemplateRestConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Interface definition for a factory of metadata template services. This allows
 * easier creation of metadata template services in a spring fashion, and makes
 * it easier to mock out services
 *
 * FIXME: refactor into base metadata template code (in interface layer) - mcc
 *
 * @author mconway
 *
 */
@Component
public class MetadataTemplateServiceFactoryViaDotIrodsImpl
		implements MetadataTemplateServiceFactory<MetadataTemplateContext> {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IRODSAccessObjectFactory irodsAccessObjectFactory;

	@Autowired
	private MetadataTemplateRestConfiguration metadataTemplateRestConfiguration;

	@Override
	public AbstractMetadataResolver<MetadataTemplateContext> instanceMetadataResolver(
			final MetadataTemplateContext templateSourceContext) throws MetadataTemplateProcessingException {
		log.info("instanceMetadataResolver()");

		if (templateSourceContext == null) {
			throw new IllegalArgumentException("null templateSourceContext");
		}

		if (templateSourceContext.getIrodsAccount() == null) {
			throw new IllegalStateException("templateSourceContext should contain an irodsAccount");
		}

		MetadataTemplateConfiguration metadataTemplateConfiguration = new MetadataTemplateConfiguration();
		metadataTemplateConfiguration
				.setPublicTemplateIdentifier(metadataTemplateRestConfiguration.getPublicTemplateRepositoryLocation());

		// template source context unused for iRODS

		return new JargonMetadataResolver(templateSourceContext, irodsAccessObjectFactory,
				metadataTemplateConfiguration);

	}

	public IRODSAccessObjectFactory getIrodsAccessObjectFactory() {
		return irodsAccessObjectFactory;
	}

	public void setIrodsAccessObjectFactory(final IRODSAccessObjectFactory irodsAccessObjectFactory) {
		this.irodsAccessObjectFactory = irodsAccessObjectFactory;
	}

	public MetadataTemplateRestConfiguration getMetadataTemplateRestConfiguration() {
		return metadataTemplateRestConfiguration;
	}

	public void setMetadataTemplateRestConfiguration(
			final MetadataTemplateRestConfiguration metadataTemplateRestConfiguration) {
		this.metadataTemplateRestConfiguration = metadataTemplateRestConfiguration;
	}

}

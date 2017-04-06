/**
 *
 */
package org.irods.jargon.rest.mdtemplate.service;

import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.core.pub.IRODSAccessObjectFactory;
import org.irods.jargon.metadatatemplate.AbstractMetadataResolver;
import org.irods.jargon.metadatatemplate.JargonMetadataResolver;
import org.irods.jargon.metadatatemplate.MetadataTemplateProcessingException;
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
public class MetadataTemplateServiceFactoryViaDotIrodsImpl<T extends TemplateSourceContext>
		implements MetadataTemplateServiceFactory<T> {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IRODSAccessObjectFactory irodsAccessObjectFactory;

	@Autowired
	private MetadataTemplateRestConfiguration metadataTemplateConfiguration;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.irods.jargon.rest.mdtemplate.service.MetadataTemplateServiceFactory#
	 * instanceMetadataResolver(org.irods.jargon.core.connection.IRODSAccount,
	 * T)
	 */
	@Override
	public AbstractMetadataResolver instanceMetadataResolver(final IRODSAccount irodsAccount,
			final T templateSourceContext) throws MetadataTemplateProcessingException {
		log.info("instanceMetadataResolver()");
		if (irodsAccount == null) {
			throw new IllegalArgumentException("null irodsAccount");
		}

		// template source context unused for iRODS

		try {
			return new JargonMetadataResolver(irodsAccount, irodsAccessObjectFactory);
		} catch (JargonException e) {
			log.error("exception processing metadata template resolver", e);
			throw new MetadataTemplateProcessingException("error creating resolver", e);
		}

	}

	public IRODSAccessObjectFactory getIrodsAccessObjectFactory() {
		return irodsAccessObjectFactory;
	}

	public void setIrodsAccessObjectFactory(final IRODSAccessObjectFactory irodsAccessObjectFactory) {
		this.irodsAccessObjectFactory = irodsAccessObjectFactory;
	}

	public MetadataTemplateRestConfiguration getMetadataTemplateConfiguration() {
		return metadataTemplateConfiguration;
	}

	public void setMetadataTemplateConfiguration(final MetadataTemplateRestConfiguration metadataTemplateConfiguration) {
		this.metadataTemplateConfiguration = metadataTemplateConfiguration;
	}

}

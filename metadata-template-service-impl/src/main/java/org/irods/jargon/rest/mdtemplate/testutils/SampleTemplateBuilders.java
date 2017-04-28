/**
 *
 */
package org.irods.jargon.rest.mdtemplate.testutils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.irods.jargon.core.pub.IRODSAccessObjectFactory;
import org.irods.jargon.metadatatemplate.DestinationEnum;
import org.irods.jargon.metadatatemplate.ElementTypeEnum;
import org.irods.jargon.metadatatemplate.MetadataElement;
import org.irods.jargon.metadatatemplate.MetadataTemplate;
import org.irods.jargon.metadatatemplate.SourceEnum;
import org.irods.jargon.metadatatemplate.ValidationStyleEnum;
import org.irods.jargon.rest.mdtemplate.config.MetadataTemplateRestConfiguration;

/**
 * Builders for metadataTemplates for default 'dot irods file' implementation
 *
 * @author mconway
 *
 */
public class SampleTemplateBuilders {

	private final MetadataTemplateRestConfiguration metadataTemplateConfiguration;
	private final IRODSAccessObjectFactory irodsAccessObjectFactory;

	/**
	 * Constructor requiring config
	 *
	 * @param metadataTemplateConfiguration
	 */
	public SampleTemplateBuilders(final MetadataTemplateRestConfiguration metadataTemplateConfiguration,
			final IRODSAccessObjectFactory irodsAccessObjectFactory) {
		super();
		this.metadataTemplateConfiguration = metadataTemplateConfiguration;
		this.irodsAccessObjectFactory = irodsAccessObjectFactory;
	}

	/**
	 * Currently this is a basic skeleton, eventually will be a well formed DC
	 * metadata template
	 *
	 * @return {@link MetadataTemplate} of a public, optional dublin core set
	 */
	public static MetadataTemplate buildDublinCoreMetadataTemplate() {
		MetadataTemplate dc = new MetadataTemplate();
		dc.setAuthor("me");
		dc.setCreated(new Date());
		dc.setModified(new Date());
		dc.setDescription("dublin core sample");
		dc.setExporter(DestinationEnum.IRODS);
		dc.setName("Dublin Core");
		dc.setRequired(false);
		dc.setSource(SourceEnum.USER);
		dc.setUuid(UUID.randomUUID());
		dc.setVersion("1.1");

		List<MetadataElement> elements = new ArrayList<MetadataElement>();

		MetadataElement contributor = new MetadataElement();
		contributor.setDescription("An entity responsible for making contributions to the resource.");
		contributor.setElementName("http://purl.org/dc/elements/1.1/contributor");
		contributor.setI18nDescription("dc.contributor.description");
		contributor.setI18nName("dc.contributor");
		contributor.setRequired(true);
		contributor.setTemplateUuid(UUID.randomUUID());
		contributor.setType(ElementTypeEnum.RAW_STRING);
		contributor.setValidationStyle(ValidationStyleEnum.DEFAULT);

		elements.add(contributor);

		MetadataElement coverage = new MetadataElement();
		coverage.setDescription(
				"The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.");
		coverage.setElementName("http://purl.org/dc/elements/1.1/coverage");
		coverage.setI18nDescription("dc.coverage.description");
		coverage.setI18nName("dc.coverage");
		coverage.setRequired(false);
		coverage.setTemplateUuid(UUID.randomUUID());
		coverage.setType(ElementTypeEnum.REF_URL);
		coverage.setValidationStyle(ValidationStyleEnum.DEFAULT);
		elements.add(coverage);

		MetadataElement creator = new MetadataElement();
		creator.setDescription("An entity primarily responsible for making the resource.");
		creator.setElementName("http://purl.org/dc/elements/1.1/contributor");
		creator.setI18nDescription("dc.contributor.description");
		creator.setI18nName("dc.contributor");
		creator.setRequired(true);
		creator.setTemplateUuid(UUID.randomUUID());
		creator.setType(ElementTypeEnum.RAW_STRING);
		creator.setValidationStyle(ValidationStyleEnum.DEFAULT);

		elements.add(creator);

		dc.setElements(elements);

		return dc;

	}

	public IRODSAccessObjectFactory getIrodsAccessObjectFactory() {
		return irodsAccessObjectFactory;
	}

	public MetadataTemplateRestConfiguration getMetadataTemplateConfiguration() {
		return metadataTemplateConfiguration;
	}

}

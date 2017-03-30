/**
 *
 */
package org.irods.jargon.rest.mdtemplate.model.utils;

import java.util.List;

import org.irods.jargon.metadatatemplate.MetadataElement;
import org.irods.jargon.metadatatemplate.MetadataTemplate;
import org.irods.jargon.rest.mdtemplate.exception.InvalidDataException;
import org.irods.jargon.rest.mdtemplate.model.MetadataTemplateList;
import org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate;
import org.joda.time.DateTime;

/**
 * Transformation utilities between mdtemplates domain model and
 * Swagger-generated POJOs. This is to keep the mdtemplate base code clean of
 * any annotations used by Swagger or REST frameworks.
 *
 * @author mconway
 *
 */
public class TemplateModelTransformer {

	/**
	 * Create the rest layer object that is the source of the JSON/XML from the
	 * base metadata template information
	 *
	 * @param metadataTemplates
	 *            <code>List</code> of {@link MetadataTemplate} coming from the
	 *            base metadata tempalte service
	 * @return {@link MetadataTemplateList} used by the REST layer
	 * @throws InvalidDataException
	 */
	public static MetadataTemplateList restMetadataTemplateListFromBaseModel(
			final List<MetadataTemplate> metadataTemplates) throws InvalidDataException {

		if (metadataTemplates == null) {
			throw new IllegalArgumentException("null metadataTemplates");
		}

		MetadataTemplateList metadataTemplateList = new MetadataTemplateList();

		for (MetadataTemplate metadataTemplate : metadataTemplates) {
			metadataTemplateList
					.addMetadataTemplateItem(restMetadataTemplateFromBaseMetadataTemplate(metadataTemplate));
		}

		return metadataTemplateList;

	}

	private static RestMetadataTemplate restMetadataTemplateFromBaseMetadataTemplate(
			final MetadataTemplate metadataTemplate) throws InvalidDataException {

		RestMetadataTemplate restTemplate = new RestMetadataTemplate();
		restTemplate.setAuthor(metadataTemplate.getAuthor());
		restTemplate.setCreated(new DateTime(metadataTemplate.getCreated()));
		restTemplate.setDescription(metadataTemplate.getDescription());
		restTemplate.addDestinationItem(restDestinationEnumFromBaseDestinationEnum(metadataTemplate.getExporter()));
		restTemplate.setModified(new DateTime(metadataTemplate.getModified()));
		restTemplate.setName(metadataTemplate.getName());
		restTemplate.setRequired(metadataTemplate.isRequired());
		restTemplate.addTypeItem(restTypeEnumFromBaseTypeEnum(metadataTemplate.getType()));
		restTemplate.setUuid(metadataTemplate.getUuid().toString());
		restTemplate.setVersion(metadataTemplate.getVersion());

		// process line item elements
		for (MetadataElement element : metadataTemplate.getElements()) {
			// FIXME: complete
		}
		return null;

	}

	/**
	 * Translate the base destination to the rest layer enumeration value
	 *
	 * @param destinationEnum
	 *            from the base impl
	 * @return destination enum from the rest layer
	 * @throws InvalidDataException
	 */
	private static org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate.DestinationEnum restDestinationEnumFromBaseDestinationEnum(
			final org.irods.jargon.metadatatemplate.DestinationEnum destinationEnum) throws InvalidDataException {
		if (destinationEnum == null) {
			throw new IllegalArgumentException("null destinationEnum");
		}

		if (destinationEnum == org.irods.jargon.metadatatemplate.DestinationEnum.IRODS) {
			return org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate.DestinationEnum.IRODS;
		} else {
			throw new InvalidDataException("unknown destination enum:" + destinationEnum);
		}
	}

	/**
	 * Translate the base template type to the rest layer template type
	 *
	 * @param typeEnum
	 *            templateType from the base impl
	 * @return template type from the rest layer
	 * @throws InvalidDataException
	 */
	private static org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate.TypeEnum restTypeEnumFromBaseTypeEnum(
			final org.irods.jargon.metadatatemplate.TemplateTypeEnum typeEnum) throws InvalidDataException {
		if (typeEnum == null) {
			throw new IllegalArgumentException("null typeEnum");
		}

		if (typeEnum == org.irods.jargon.metadatatemplate.TemplateTypeEnum.FORM_BASED) {
			return org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate.TypeEnum.FORM_BASED;
		} else {
			throw new InvalidDataException("unknown type enum:" + typeEnum);
		}
	}

}

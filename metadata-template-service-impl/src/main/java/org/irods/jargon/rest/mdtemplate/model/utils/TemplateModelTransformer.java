/**
 *
 */
package org.irods.jargon.rest.mdtemplate.model.utils;

import java.util.List;

import org.irods.jargon.metadatatemplate.DestinationEnum;
import org.irods.jargon.metadatatemplate.MetadataElement;
import org.irods.jargon.metadatatemplate.MetadataTemplate;
import org.irods.jargon.rest.mdtemplate.exception.InvalidDataException;
import org.irods.jargon.rest.mdtemplate.model.MetadataTemplateList;
import org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate;
import org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement;
import org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement.ElementTypeEnum;
import org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement.ValidationStyleEnum;
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
	 *            base metadata template service
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

	/**
	 * 
	 * @param restMetadataTemplate
	 * @return
	 * @throws InvalidDataException
	 */
	public static MetadataTemplate baseMetadataTemplateFromRestModel(final RestMetadataTemplate restMetadataTemplate)
			throws InvalidDataException {

		MetadataTemplate metadataTemplate = new MetadataTemplate();
		metadataTemplate.setAuthor(restMetadataTemplate.getAuthor());
		metadataTemplate.setCreated(restMetadataTemplate.getCreated().toDate());
		metadataTemplate.setDescription(restMetadataTemplate.getDescription());
		metadataTemplate.setExporter(baseDestinationEnumFromRestDestinationEnum(metadataTemplate.getExporter()));

	}

	/**
	 * Convert from the rest layer destination to the base layer destination
	 * 
	 * @param exporter
	 * @return
	 */
	private static org.irods.jargon.metadatatemplate.DestinationEnum baseDestinationEnumFromRestDestinationEnum(
			DestinationEnum exporter) {
		if (exporter == null) {
			throw new IllegalArgumentException("null exporter");
		}

		if (exporter == DestinationEnum.IRODS) {
			return org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate.DestinationEnum.IRODS;
		} else {
			throw new InvalidDataException("unknown destination enum:" + destinationEnum);
		}
	}

	/**
	 * Build a rest-layer representation of the metadata template
	 *
	 * @param metadataTemplate
	 *            base layer {@link MetadataTemplate}
	 * @return
	 * @throws InvalidDataException
	 */
	public static RestMetadataTemplate restMetadataTemplateFromBaseMetadataTemplate(
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
			restTemplate.addMetadataTemplateElementsItem(restMetadataElementFromBaseElement(element));
		}
		return restTemplate;

	}

	public static RestMetadataTemplateElement restMetadataElementFromBaseElement(final MetadataElement element)
			throws InvalidDataException {

		RestMetadataTemplateElement restElement = new RestMetadataTemplateElement();
		restElement.setDefaultValue(element.getDefaultValue());
		restElement.setDescription(element.getDescription());
		restElement.addElementTypeItem(restElementTypeEnumFromBaseElementTypeEnum(element.getType()));
		restElement.setI18nDescription(element.getI18nDescription());
		restElement.setI18nName(element.getI18nName());
		restElement.setName(element.getName());
		restElement.setRequired(element.isRequired());
		restElement.setUuid(element.getTemplateUuid().toString());
		for (String option : element.getValidationOptions()) {
			restElement.addValidationOptionsItem(option);
		}
		restElement.addValidationStyleItem(
				restValidationStyleEnumFromBaseValidationStyleEnum(element.getValidationStyle()));
		return restElement;

	}

	/**
	 * Get the rest layer {@link ValidationStyleEnum} translated from the data
	 * layer
	 *
	 * @param validationStyle
	 *            {@link org.irods.jargon.metadatatemplate.ValidationStyleEnum}
	 *            from the data layer
	 * @return {@link ValidationStyleEnum} from the rest layer
	 * @throws InvalidDataException
	 */
	public static ValidationStyleEnum restValidationStyleEnumFromBaseValidationStyleEnum(
			final org.irods.jargon.metadatatemplate.ValidationStyleEnum validationStyle) throws InvalidDataException {

		if (validationStyle == null) {
			throw new IllegalArgumentException("null validationStyle");
		}

		org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement.ValidationStyleEnum returnValidationStyle;
		switch (validationStyle) {
		case DEFAULT:
			returnValidationStyle = org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement.ValidationStyleEnum.DEFAULT;
			break;
		case IS:
			returnValidationStyle = org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement.ValidationStyleEnum.IS;
			break;
		case IN_LIST:
			returnValidationStyle = org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement.ValidationStyleEnum.IN_LIST;
			break;
		case IN_RANGE:
			returnValidationStyle = org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement.ValidationStyleEnum.IN_RANGE;
			break;
		case IN_RANGE_EXCLUSIVE:
			returnValidationStyle = org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement.ValidationStyleEnum.IN_RANGE_EXCLUSIVE;
			break;
		case REGEX:
			returnValidationStyle = org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement.ValidationStyleEnum.REGEX;
			break;
		case FOLLOW_REF:
			returnValidationStyle = org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement.ValidationStyleEnum.FOLLOW_REF;
			break;
		case DO_NOT_VALIDATE:
			returnValidationStyle = org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement.ValidationStyleEnum.DO_NOT_VALIDATE;
			break;
		default:
			throw new InvalidDataException("unknown validation style:" + validationStyle);

		}

		return returnValidationStyle;
	}

	/**
	 * Translate the base destination to the rest layer enumeration value
	 *
	 * @param destinationEnum
	 *            from the base impl
	 * @return destination enum from the rest layer
	 * @throws InvalidDataException
	 */
	public static org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate.DestinationEnum restDestinationEnumFromBaseDestinationEnum(
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
	public static org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate.TypeEnum restTypeEnumFromBaseTypeEnum(
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

	/**
	 * Translate the element type from the underlying library layer to the rest
	 * layer enumberation
	 *
	 * @param elementTypeEnum
	 *            {@link org.irods.jargon.metadatatemplate.ElementTypeEnum}
	 *            representing the element type in the data layer
	 * @return {@link org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement.ElementTypeEnum}
	 *         in the rest layer
	 * @throws InvalidDataException
	 */
	public static org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement.ElementTypeEnum restElementTypeEnumFromBaseElementTypeEnum(
			final org.irods.jargon.metadatatemplate.ElementTypeEnum elementTypeEnum) throws InvalidDataException {

		RestMetadataTemplateElement.ElementTypeEnum returnEnum;
		switch (elementTypeEnum) {
		case RAW_STRING:
			returnEnum = ElementTypeEnum.RAW_STRING;
			break;
		case RAW_TEXT:
			returnEnum = ElementTypeEnum.RAW_TEXT;
			break;
		case RAW_URL:
			returnEnum = ElementTypeEnum.RAW_URL;
			break;
		case RAW_INT:
			returnEnum = ElementTypeEnum.RAW_INT;
			break;
		case RAW_FLOAT:
			returnEnum = ElementTypeEnum.RAW_FLOAT;
			break;
		case RAW_DATE:
			returnEnum = ElementTypeEnum.RAW_DATE;
			break;
		case RAW_TIME:
			returnEnum = ElementTypeEnum.RAW_TIME;
			break;
		case RAW_DATETIME:
			returnEnum = ElementTypeEnum.RAW_DATETIME;
			break;
		case REF_IRODS_QUERY:
			returnEnum = ElementTypeEnum.REF_IRODS_QUERY;
			break;
		case REF_IRODS_CATALOG:
			returnEnum = ElementTypeEnum.REF_IRODS_CATALOG;
			break;
		case REF_URL:
			returnEnum = ElementTypeEnum.REF_URL;
			break;
		case LIST_STRING:
			returnEnum = ElementTypeEnum.LIST_STRING;
			break;
		case LIST_INT:
			returnEnum = ElementTypeEnum.LIST_INT;
			break;

		case LIST_FLOAT:
			returnEnum = ElementTypeEnum.LIST_FLOAT;
			break;
		default:
			throw new InvalidDataException("unknown type enum:" + elementTypeEnum);

		}

		return returnEnum;

	}

}

/**
 * 
 */
package org.irods.jargon.rest.mdtemplate.model.utils;

import java.util.List;

import org.irods.jargon.metadatatemplate.MetadataTemplate;
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
	 */
	public static MetadataTemplateList restMetadataTemplateListFromBaseModel(
			final List<MetadataTemplate> metadataTemplates) {

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
			MetadataTemplate metadataTemplate) {

		RestMetadataTemplate restTemplate = new RestMetadataTemplate();
		restTemplate.setAuthor(metadataTemplate.getAuthor());
		restTemplate.setCreated(new DateTime(metadataTemplate.getCreated()));
		restTemplate.setDescription(metadataTemplate.getDescription());
		restTemplate.setDestination(metadataTemplate.getExporter());

	}

}

package org.irods.jargon.rest.mdtemplate;

import org.irods.jargon.metadatatemplate.MetadataTemplateProcessingException;
import org.irods.jargon.rest.mdtemplate.exception.MetadataTemplateException;
import org.irods.jargon.rest.mdtemplate.model.MetadataTemplateList;
import org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate;
import org.irods.jargon.rest.mdtemplate.service.MetadataTemplateResolverApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-03-27T11:39:55.216-04:00")

@Controller
public class TemplatesApiController implements TemplatesApi {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MetadataTemplateResolverApiService metadataTemplateResolverApiService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.irods.jargon.rest.mdtemplate.TemplatesApi#listPublicTemplates()
	 */
	@Override
	public ResponseEntity<MetadataTemplateList> listPublicTemplates()
			throws MetadataTemplateException, MetadataTemplateProcessingException {
		ResponseEntity<MetadataTemplateList> response = new ResponseEntity<MetadataTemplateList>(
				metadataTemplateResolverApiService.listPublicTemplates(), HttpStatus.OK);

		return response;
	}

	@Override
	public ResponseEntity<Void> addPublicTemplate(

			@ApiParam(value = "Metadata template to be added", required = true) @RequestBody RestMetadataTemplate body

	) throws MetadataTemplateException, MetadataTemplateProcessingException {

		metadataTemplateResolverApiService.savePublicTemplate(body);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	public MetadataTemplateResolverApiService getMetadataTemplateResolverApiService() {
		return metadataTemplateResolverApiService;
	}

	public void setMetadataTemplateResolverApiService(
			MetadataTemplateResolverApiService metadataTemplateResolverApiService) {
		this.metadataTemplateResolverApiService = metadataTemplateResolverApiService;
	}

}

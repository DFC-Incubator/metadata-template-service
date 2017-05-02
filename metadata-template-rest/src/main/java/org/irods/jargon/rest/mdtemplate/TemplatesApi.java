package org.irods.jargon.rest.mdtemplate;

import org.irods.jargon.metadatatemplate.MetadataTemplateProcessingException;
import org.irods.jargon.rest.mdtemplate.exception.MetadataTemplateException;
import org.irods.jargon.rest.mdtemplate.model.MetadataTemplateList;
import org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-03-27T11:39:55.216-04:00")

@Api(value = "templates", description = "the templates API")
public interface TemplatesApi {

	@ApiOperation(value = "List publicly available metadata templates", notes = "List all publicly available metadata templates in the configured public repo", response = MetadataTemplateList.class, tags = {
			"query", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "List of metadata templates retrieved", response = MetadataTemplateList.class) })
	@RequestMapping(value = "/templates/public", produces = { "application/json",
			"application/xml" }, method = RequestMethod.GET)
	ResponseEntity<MetadataTemplateList> listPublicTemplates()
			throws MetadataTemplateException, MetadataTemplateProcessingException;

	@ApiOperation(value = "Add a public metadata template", notes = "Add a metadata template to the public directory", response = Void.class, tags = {
			"template management", })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Indicates the metadata template was created", response = Void.class) })
	@RequestMapping(value = "/templates/public", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" }, method = RequestMethod.POST)
	ResponseEntity<Void> addPublicTemplate(

			@ApiParam(value = "Metadata template to be added", required = true) @RequestBody RestMetadataTemplate body

	) throws MetadataTemplateException, MetadataTemplateProcessingException;

}

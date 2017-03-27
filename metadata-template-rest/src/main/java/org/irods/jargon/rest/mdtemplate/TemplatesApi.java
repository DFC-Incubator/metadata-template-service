package org.irods.jargon.rest.mdtemplate;

import org.irods.jargon.rest.mdtemplate.model.MetadataTemplateList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
	ResponseEntity<MetadataTemplateList> listPublicTemplates();

}

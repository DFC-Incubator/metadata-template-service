package org.irods.jargon.rest.mdtemplate;

import org.irods.jargon.rest.exception.IrodsRestException;
import org.irods.jargon.rest.mdtemplate.model.Ping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-03-27T21:38:56.734-04:00")

@Api(value = "server", description = "the server API")
public interface ServerApi {

	@ApiOperation(value = "Get a ping back from the server", notes = "Call iRODS as an authorized user and get back a simple ping response", response = Ping.class, tags = {
			"status", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful ping, containing info on how long it too the REST backend to connect to iRODS", response = Ping.class) })
	@RequestMapping(value = "/server/ping", produces = { "application/json",
			"application/xml" }, method = RequestMethod.GET)
	ResponseEntity<Ping> server(
			@ApiParam(value = "causes ping to only reach the REST mid tier and not query the back-end, provides a simple heartbeat of the mid-tier.  By default a ping will talk to the back end iRODS server", defaultValue = "false") @RequestParam(value = "midTierOnly", required = false, defaultValue = "false") Boolean midTierOnly

	) throws IrodsRestException;

}

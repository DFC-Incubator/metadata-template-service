package org.irods.jargon.rest.mdtemplate;

import org.irods.jargon.metadatatemplate.MetadataTemplate;
import org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate;
import org.irods.jargon.rest.mdtemplate.model.utils.TemplateModelTransformer;
import org.irods.jargon.rest.mdtemplate.testutils.SampleTemplateBuilders;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TemplatesApiControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@TestConfiguration
	static class Config {

		@Bean
		public RestTemplateBuilder restTemplateBuilder() {
			return new RestTemplateBuilder().basicAuthorization("test1", "test");

		}

	}

	@Test
	public void testAddPublicTemplate() throws Exception {
		MetadataTemplate testTemplate = SampleTemplateBuilders.buildDublinCoreMetadataTemplate();
		RestMetadataTemplate restMetadataTemplate = TemplateModelTransformer
				.restMetadataTemplateFromBaseMetadataTemplate(testTemplate);
		ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/templates/public", restMetadataTemplate,
				Void.class);
		Assert.assertNotNull("no response", responseEntity);
		Assert.assertEquals("did not get response 201", 201, responseEntity.getStatusCodeValue());

	}

}

package org.irods.jargon.rest.mdtemplate;

import java.util.Properties;

import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.pub.IRODSFileSystem;
import org.irods.jargon.core.pub.io.IRODSFile;
import org.irods.jargon.metadatatemplate.MetadataTemplate;
import org.irods.jargon.rest.mdtemplate.config.MetadataTemplateRestConfiguration;
import org.irods.jargon.rest.mdtemplate.model.MetadataTemplateList;
import org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate;
import org.irods.jargon.rest.mdtemplate.model.utils.TemplateModelTransformer;
import org.irods.jargon.rest.mdtemplate.testutils.SampleTemplateBuilders;
import org.irods.jargon.testutils.AssertionHelper;
import org.irods.jargon.testutils.IRODSTestSetupUtilities;
import org.irods.jargon.testutils.TestingPropertiesHelper;
import org.irods.jargon.testutils.filemanip.ScratchFileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
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

	@Autowired
	private MetadataTemplateRestConfiguration metadataTemplateRestConfiguration;

	private static Properties testingProperties = new Properties();
	private static TestingPropertiesHelper testingPropertiesHelper = new TestingPropertiesHelper();
	private static ScratchFileUtils scratchFileUtils = null;
	public static final String IRODS_TEST_SUBDIR_PATH = "TemplatesApiControllerTest";
	private static IRODSTestSetupUtilities irodsTestSetupUtilities = null;
	private static AssertionHelper assertionHelper = null;
	private static IRODSFileSystem irodsFileSystem;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestingPropertiesHelper testingPropertiesLoader = new TestingPropertiesHelper();
		testingProperties = testingPropertiesLoader.getTestProperties();
		scratchFileUtils = new ScratchFileUtils(testingProperties);
		scratchFileUtils.clearAndReinitializeScratchDirectory(IRODS_TEST_SUBDIR_PATH);
		irodsTestSetupUtilities = new IRODSTestSetupUtilities();
		irodsTestSetupUtilities.initializeIrodsScratchDirectory();
		irodsTestSetupUtilities.initializeDirectoryForTest(IRODS_TEST_SUBDIR_PATH);
		assertionHelper = new AssertionHelper();
		irodsFileSystem = IRODSFileSystem.instance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		irodsFileSystem.closeAndEatExceptions();
	}

	@TestConfiguration
	static class Config {

		@Bean
		public RestTemplateBuilder restTemplateBuilder() {
			return new RestTemplateBuilder().basicAuthorization("test1", "test");
		}
	}

	@Test
	public void testAddThenListPublicTemplate() throws Exception {
		String publicPath = metadataTemplateRestConfiguration.getPublicTemplateRepositoryLocation();
		IRODSAccount irodsAccount = testingPropertiesHelper.buildIRODSAccountFromTestProperties(testingProperties);

		IRODSFile publicDir = irodsFileSystem.getIRODSFileFactory(irodsAccount).instanceIRODSFile(publicPath);
		publicDir.delete();
		MetadataTemplate testTemplate = SampleTemplateBuilders.buildDublinCoreMetadataTemplate();
		RestMetadataTemplate restMetadataTemplate = TemplateModelTransformer
				.restMetadataTemplateFromBaseMetadataTemplate(testTemplate);
		ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/templates/public", restMetadataTemplate,
				Void.class);
		Assert.assertNotNull("no response", responseEntity);
		Assert.assertEquals("did not get response 201", 201, responseEntity.getStatusCodeValue());

		ResponseEntity<MetadataTemplateList> listEntity = restTemplate.getForEntity("/templates/public",
				MetadataTemplateList.class);

		Assert.assertNotNull("no response", listEntity);
		Assert.assertEquals("did not get response 200", 200, listEntity.getStatusCodeValue());

	}

}

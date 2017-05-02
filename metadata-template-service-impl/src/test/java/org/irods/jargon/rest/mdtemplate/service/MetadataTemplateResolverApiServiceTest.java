package org.irods.jargon.rest.mdtemplate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.connection.auth.AuthResponse;
import org.irods.jargon.core.pub.IRODSAccessObjectFactory;
import org.irods.jargon.metadatatemplate.AbstractMetadataResolver;
import org.irods.jargon.metadatatemplate.MetadataTemplate;
import org.irods.jargon.metadatatemplate.MetadataTemplateContext;
import org.irods.jargon.metadatatemplate.MetadataTemplateLocationTypeEnum;
import org.irods.jargon.metadatatemplate.MetadataTemplateServiceFactory;
import org.irods.jargon.rest.mdtemplate.model.MetadataTemplateList;
import org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate;
import org.irods.jargon.rest.mdtemplate.model.utils.TemplateModelTransformer;
import org.irods.jargon.rest.mdtemplate.testutils.SampleTemplateBuilders;
import org.irods.jargon.rest.security.IrodsAuthentication;
import org.irods.jargon.rest.security.SecurityContextHelper;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class MetadataTemplateResolverApiServiceTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testListPublicTemplates() throws Exception {
		IRODSAccessObjectFactory iaf = Mockito.mock(IRODSAccessObjectFactory.class);
		MetadataTemplateServiceFactory<MetadataTemplateContext> templateServiceFactory = Mockito
				.mock(MetadataTemplateServiceFactory.class);
		IRODSAccount dummyAccount = new IRODSAccount("boo", 0, "boo", "boo", "boo", "boo", "boo");
		AuthResponse authResponse = new AuthResponse();
		IrodsAuthentication irodsAuthentication = new IrodsAuthentication(dummyAccount, authResponse);
		SecurityContextHelper securityContextHelper = Mockito.mock(SecurityContextHelper.class);
		Mockito.when(securityContextHelper.obtainIrodsAuthenticationFromContext()).thenReturn(irodsAuthentication);

		AbstractMetadataResolver<MetadataTemplateContext> resolver = Mockito.mock(AbstractMetadataResolver.class);
		List<MetadataTemplate> metadataTemplates = new ArrayList<MetadataTemplate>();
		metadataTemplates.add(SampleTemplateBuilders.buildDublinCoreMetadataTemplate());
		Mockito.when(resolver.listPublicTemplates()).thenReturn(metadataTemplates);

		Mockito.when(templateServiceFactory.instanceMetadataResolver(Mockito.any(MetadataTemplateContext.class)))
				.thenReturn(resolver);

		MetadataTemplateResolverApiService service = new MetadataTemplateResolverApiService();
		service.setSecurityContextHelper(securityContextHelper);
		service.setIrodsAccessObjectFactory(iaf);
		service.setMetadataTemplateServiceFactory(templateServiceFactory);

		MetadataTemplateList actual = service.listPublicTemplates();
		Assert.assertNotNull("no list returned", actual);

	}

	@Test
	public void testAddPublicTemplate() throws Exception {
		IRODSAccessObjectFactory iaf = Mockito.mock(IRODSAccessObjectFactory.class);
		@SuppressWarnings("unchecked")
		MetadataTemplateServiceFactory<MetadataTemplateContext> templateServiceFactory = Mockito
				.mock(MetadataTemplateServiceFactory.class);
		IRODSAccount dummyAccount = new IRODSAccount("boo", 0, "boo", "boo", "boo", "boo", "boo");
		AuthResponse authResponse = new AuthResponse();
		IrodsAuthentication irodsAuthentication = new IrodsAuthentication(dummyAccount, authResponse);
		SecurityContextHelper securityContextHelper = Mockito.mock(SecurityContextHelper.class);
		Mockito.when(securityContextHelper.obtainIrodsAuthenticationFromContext()).thenReturn(irodsAuthentication);

		MetadataTemplate testTemplate = SampleTemplateBuilders.buildDublinCoreMetadataTemplate();

		AbstractMetadataResolver<MetadataTemplateContext> resolver = Mockito.mock(AbstractMetadataResolver.class);
		MetadataTemplate metadataTemplate = SampleTemplateBuilders.buildDublinCoreMetadataTemplate();
		Mockito.when(resolver.saveTemplate(metadataTemplate, MetadataTemplateLocationTypeEnum.PUBLIC))
				.thenReturn(UUID.randomUUID());

		Mockito.when(templateServiceFactory.instanceMetadataResolver(Mockito.any(MetadataTemplateContext.class)))
				.thenReturn(resolver);
		MetadataTemplateResolverApiService service = new MetadataTemplateResolverApiService();
		service.setSecurityContextHelper(securityContextHelper);
		service.setIrodsAccessObjectFactory(iaf);
		service.setMetadataTemplateServiceFactory(templateServiceFactory);
		UUID uuid = UUID.randomUUID();
		Mockito.when(resolver.saveTemplate(Mockito.any(MetadataTemplate.class),
				Mockito.any(MetadataTemplateLocationTypeEnum.class))).thenReturn(uuid);
		RestMetadataTemplate restMetadataTemplate = TemplateModelTransformer
				.restMetadataTemplateFromBaseMetadataTemplate(testTemplate);

		UUID actual = service.savePublicTemplate(restMetadataTemplate);
		Assert.assertNotNull("no UUID returned", actual);

	}

}

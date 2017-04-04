package org.irods.jargon.rest.mdtemplate.service;

import java.util.ArrayList;
import java.util.List;

import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.connection.auth.AuthResponse;
import org.irods.jargon.core.pub.IRODSAccessObjectFactory;
import org.irods.jargon.metadatatemplate.AbstractMetadataResolver;
import org.irods.jargon.metadatatemplate.MetadataTemplate;
import org.irods.jargon.rest.mdtemplate.model.MetadataTemplateList;
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
		MetadataTemplateServiceFactory<TemplateSourceContext> templateServiceFactory = Mockito
				.mock(MetadataTemplateServiceFactory.class);
		IRODSAccount dummyAccount = new IRODSAccount("boo", 0, "boo", "boo", "boo", "boo", "boo");
		AuthResponse authResponse = new AuthResponse();
		IrodsAuthentication irodsAuthentication = new IrodsAuthentication(dummyAccount, authResponse);
		SecurityContextHelper securityContextHelper = Mockito.mock(SecurityContextHelper.class);
		Mockito.when(securityContextHelper.obtainIrodsAuthenticationFromContext()).thenReturn(irodsAuthentication);

		AbstractMetadataResolver resolver = Mockito.mock(AbstractMetadataResolver.class);
		List<MetadataTemplate> metadataTemplates = new ArrayList<MetadataTemplate>();
		metadataTemplates.add(SampleTemplateBuilders.buildDublinCoreMetadataTemplate());
		Mockito.when(resolver.listPublicTemplates()).thenReturn(metadataTemplates);
		Mockito.when(templateServiceFactory.instanceMetadataResolver(dummyAccount, null)).thenReturn(resolver);

		MetadataTemplateResolverApiService service = new MetadataTemplateResolverApiService();
		service.setSecurityContextHelper(securityContextHelper);
		service.setIrodsAccessObjectFactory(iaf);
		service.setMetadataTemplateServiceFactory(templateServiceFactory);

		MetadataTemplateList actual = service.listPublicTemplates();
		Assert.assertNotNull("no list returned", actual);

	}

}

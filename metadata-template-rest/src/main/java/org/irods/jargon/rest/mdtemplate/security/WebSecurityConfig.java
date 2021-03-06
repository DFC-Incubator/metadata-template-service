/**
 *
 */
package org.irods.jargon.rest.mdtemplate.security;

import java.util.Arrays;

import org.irods.jargon.core.connection.IRODSSession;
import org.irods.jargon.core.pub.IRODSAccessObjectFactory;
import org.irods.jargon.rest.configuration.RestConfiguration;
import org.irods.jargon.rest.security.ConnectionCloseFilter;
import org.irods.jargon.rest.security.IrodsAuthenticationProvider;
import org.irods.jargon.rest.security.IrodsBasicAuthEntryPoint;
import org.irods.jargon.rest.utils.RestConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Spring security configurer
 *
 * @author mconway
 *
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private RestConfiguration restConfiguration;
	@Autowired
	private IRODSSession irodsSession;
	@Autowired
	private IRODSAccessObjectFactory irodsAccessObjectFactory;
	@Autowired
	private IrodsAuthenticationProvider irodsAuthenticationProvider;
	@Autowired
	private IrodsBasicAuthEntryPoint irodsBasicAuthEntryPoint;
	@Autowired
	private ConnectionCloseFilter connectionCloseFilter;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * @return the restConfiguration
	 */
	public RestConfiguration getRestConfiguration() {
		return restConfiguration;
	}

	/**
	 * @param restConfiguration
	 *            the restConfiguration to set
	 */
	public void setRestConfiguration(final RestConfiguration restConfiguration) {
		this.restConfiguration = restConfiguration;
	}

	/**
	 * @return the irodsSession
	 */
	public IRODSSession getIrodsSession() {
		return irodsSession;
	}

	/**
	 * @param irodsSession
	 *            the irodsSession to set
	 */
	public void setIrodsSession(final IRODSSession irodsSession) {
		this.irodsSession = irodsSession;
	}

	/**
	 * @return the irodsAccessObjectFactory
	 */
	public IRODSAccessObjectFactory getIrodsAccessObjectFactory() {
		return irodsAccessObjectFactory;
	}

	/**
	 * @param irodsAccessObjectFactory
	 *            the irodsAccessObjectFactory to set
	 */
	public void setIrodsAccessObjectFactory(final IRODSAccessObjectFactory irodsAccessObjectFactory) {
		this.irodsAccessObjectFactory = irodsAccessObjectFactory;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter
	 * #configure(org.springframework.security.config
	 * .annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		log.info("configure()");

		http.authenticationProvider(irodsAuthenticationProvider).authorizeRequests().anyRequest().authenticated().and()
				.cors().and().httpBasic().realmName(RestConstants.DFC_REALM)
				.authenticationEntryPoint(irodsBasicAuthEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(connectionCloseFilter, SecurityContextPersistenceFilter.class);
		http.csrf().disable();

	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(restConfiguration.getCorsOrigins());
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	/**
	 * @return the irodsAuthenticationProvider
	 */
	public IrodsAuthenticationProvider getIrodsAuthenticationProvider() {
		return irodsAuthenticationProvider;
	}

	/**
	 * @param irodsAuthenticationProvider
	 *            the irodsAuthenticationProvider to set
	 */
	public void setIrodsAuthenticationProvider(final IrodsAuthenticationProvider irodsAuthenticationProvider) {
		this.irodsAuthenticationProvider = irodsAuthenticationProvider;
	}

	/**
	 * @return the irodsBasicAuthEntryPoint
	 */
	public IrodsBasicAuthEntryPoint getIrodsBasicAuthEntryPoint() {
		return irodsBasicAuthEntryPoint;
	}

	/**
	 * @param irodsBasicAuthEntryPoint
	 *            the irodsBasicAuthEntryPoint to set
	 */
	public void setIrodsBasicAuthEntryPoint(final IrodsBasicAuthEntryPoint irodsBasicAuthEntryPoint) {
		this.irodsBasicAuthEntryPoint = irodsBasicAuthEntryPoint;
	}

}

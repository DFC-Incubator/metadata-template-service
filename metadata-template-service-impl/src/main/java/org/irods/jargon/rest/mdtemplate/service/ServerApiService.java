/**
 * 
 */
package org.irods.jargon.rest.mdtemplate.service;

import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.core.pub.EnvironmentalInfoAO;
import org.irods.jargon.core.pub.IRODSAccessObjectFactory;
import org.irods.jargon.rest.exception.IrodsRestException;
import org.irods.jargon.rest.mdtemplate.model.Ping;
import org.irods.jargon.rest.security.IrodsAuthentication;
import org.irods.jargon.rest.security.SecurityContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * Back end to server service (ping, environmental info)
 * 
 * @author mconway
 *
 */
@Component
public class ServerApiService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IRODSAccessObjectFactory irodsAccessObjectFactory;

	/**
	 * Do a ping of iRODS for timing/heartbeat
	 * 
	 * @param midTierOnly
	 *            <code>boolean</code> that indicates whether to go back to the
	 *            iRODS server (<code>true</code> means just ping the mid-tier)
	 * @return {@link Ping} with timing data
	 * @throws IrodsRestException
	 */
	public org.irods.jargon.rest.mdtemplate.model.Ping ping(Boolean midTierOnly) throws IrodsRestException {

		log.info("server()");
		if (midTierOnly == null) {
			midTierOnly = false;
		}

		IrodsAuthentication irodsAuthentication = SecurityContextHelper.obtainIrodsAuthenticationFromContext();

		float millis = 0.0f;
		if (!midTierOnly) {
			log.info("doing a ping!");
			long startTime = System.currentTimeMillis();
			log.info("startTime:{}", startTime);
			try {
				log.info("accessing irods");
				EnvironmentalInfoAO environmentalInfoAO = irodsAccessObjectFactory
						.getEnvironmentalInfoAO(irodsAuthentication.getIrodsAccount());
				environmentalInfoAO.getIRODSServerCurrentTime();
				log.info("got properties");
			} catch (JargonException e) {
				log.error("Error pinging back end irods server", e);
				throw new IrodsRestException(e);
			}
			long endTime = System.currentTimeMillis();
			millis = endTime - startTime;
			log.info("endTime:{}", endTime);

		}

		Ping ping = new Ping();
		ping.setPingTime(millis);

		return ping;

	}

	public IRODSAccessObjectFactory getIrodsAccessObjectFactory() {
		return irodsAccessObjectFactory;
	}

	public void setIrodsAccessObjectFactory(IRODSAccessObjectFactory irodsAccessObjectFactory) {
		this.irodsAccessObjectFactory = irodsAccessObjectFactory;
	}

}

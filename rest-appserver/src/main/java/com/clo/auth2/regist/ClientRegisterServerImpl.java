package com.clo.auth2.regist;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.BaseClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.stereotype.Service;

@Service
public class ClientRegisterServerImpl implements ClientRegisterServer {

	private static Log logger = LogFactory
			.getLog(ClientRegisterServerImpl.class);

	@Autowired
	private ClientRegistrationService clientDetails;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xiaozhi.auth2.regist.ClientRegisterServer#addClient(org.springframework
	 * .security.oauth2.provider.BaseClientDetails)
	 */
	public BaseClientDetails addClient(final BaseClientDetails clientDetails) {
		clientDetails.setAuthorizedGrantTypes(Arrays.asList("authorization_code", "refresh_token", "implicit"));
		clientDetails.setClientId("tonr");
		clientDetails.setClientSecret("secret");
		clientDetails.setScope(Arrays.asList("read"));
		clientDetails.setAccessTokenValiditySeconds(60 * 60);
		clientDetails.setRefreshTokenValiditySeconds(60 * 60);
		clientDetails.setAuthorities(clientDetails.getAuthorities());
		this.clientDetails.addClientDetails(clientDetails);
		return clientDetails;
	}

	public void delClient(String clientId) {
		this.clientDetails.removeClientDetails(clientId);
	}

}

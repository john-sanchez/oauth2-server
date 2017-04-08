/**
 * 
 */
package io.johnsanchez.oauth2s.model.oauth;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author John
 *
 */
@Entity
@Table(name="oauth_client_details")
public class OauthClientDetails implements Serializable {

	private static final long serialVersionUID = -8882551576029768442L;
	
	@Id
	@Column(name="client_id", length=256)
	private String clientId;
	
	@Column(name="resource_ids", length=256)
	private String resourceIds;
	
	@Column(name="client_secret", length=256)
	private String clientSecret;
	
	@Column(name="scope", length=256)
	private String scope;
	
	@Column(name="authorized_grant_types", length=256)
	private String authorizedGrantTypes;
	
	@Column(name="web_server_redirect_uri", length=256)
	private String webServerRedirectUri;
	
	@Column(name="authorities", length=256)
	private String authorities;
	
	@Column(name="access_token_validity")
	private Integer accessTokenValidity;
	
	@Column(name="refresh_token_validity")
	private Integer refreshTokenValidity;
	
	@Column(name="additional_information", length=4000)
	private String additionalInformation;
	
	@Column(name="autoapprove", length=256)
	private String autoapprove;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public String getWebServerRedirectUri() {
		return webServerRedirectUri;
	}

	public void setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri = webServerRedirectUri;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public void setAccessTokenValidity(Integer accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public Integer getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public void setRefreshTokenValidity(Integer refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getAutoapprove() {
		return autoapprove;
	}

	public void setAutoapprove(String autoapprove) {
		this.autoapprove = autoapprove;
	}

}

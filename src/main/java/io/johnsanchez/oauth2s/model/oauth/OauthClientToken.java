/**
 * 
 */
package io.johnsanchez.oauth2s.model.oauth;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author John
 *
 */
@Entity
@Table(name="oauth_client_token")
public class OauthClientToken implements Serializable {

	private static final long serialVersionUID = 6769537157186379885L;
	
	@Column(name="token_id", length=256)
	private String tokenId;
	
	@Lob
	@Column(name="token")
	private byte[] token;
	
	@Id
	@Column(name="authentication_id", length=256)
	private String authenticationId;
	
	@Column(name="user_name", length=256)
	private String userName;
	
	@Column(name="client_id", length=256)
	private String clientId;

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public byte[] getToken() {
		return token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}

	public String getAuthenticationId() {
		return authenticationId;
	}

	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

}

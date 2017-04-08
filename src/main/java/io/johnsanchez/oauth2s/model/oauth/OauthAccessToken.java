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
@Table(name="oauth_access_token")
public class OauthAccessToken implements Serializable {

	private static final long serialVersionUID = 8487178121312149801L;
	
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
	
	@Lob
	@Column(name="authentication")
	private byte[] authentication; // LONGVARBINARY,
	
	@Column(name="refresh_token", length=256)
	private String refreshToken;

}

/**
 * 
 */
package io.johnsanchez.oauth2s.model.oauth;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author John
 *
 */
@Entity
@Table(name="oauth_approvals")
public class OauthApprovals implements Serializable {
	private static final long serialVersionUID = -4333615733786671979L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="userId", length=256)
	private String userId;
	
	@Column(name="clientId", length=256)
	private String clientId;
	
	@Column(name="scope", length=256)
	private String scope;
	
	@Column(name="expiresAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiresAt;
	
	@Column(name="lastModifiedAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedAt;
	
	@Column(name="status", length=10)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

}

package io.johnsanchez.oauth2s.model.oauth;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="oauth_code")
public class OauthCode implements Serializable {
	private static final long serialVersionUID = 2849544787296269625L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="code", length=256)
	private String code;
	
	@Lob
	@Column(name="authentication")
	private byte[] authentication;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte[] getAuthentication() {
		return authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}
}

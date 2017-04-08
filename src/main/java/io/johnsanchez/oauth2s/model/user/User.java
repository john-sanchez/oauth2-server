package io.johnsanchez.oauth2s.model.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.johnsanchez.oauth2s.model.base.BaseEntity;
import io.johnsanchez.oauth2s.model.enums.UserStatus;

@Entity
@Table(name="USR")
public class User extends BaseEntity {

	private static final long serialVersionUID = 552332655312356448L;

	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	@JsonIgnore
	private String password;
	
	@Column(name="STATUS")
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	@Column(name="ROLE_ID")
	private String roleId;
	
	@ManyToOne
	@JoinColumn(name="ROLE_ID", insertable=false, updatable=false)
	private Role role;
	
	@Column(name="ACTIVE_FROM")
	private Date activeFrom;
	
	@Column(name="ACTIVE_TO")
	private Date activeTo;
	
	@Column(name="PASSWORD_UPDATED_ON")
	private Date passwordUpdatedOn;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Date getActiveFrom() {
		return activeFrom;
	}

	public void setActiveFrom(Date activeFrom) {
		this.activeFrom = activeFrom;
	}

	public Date getActiveTo() {
		return activeTo;
	}

	public void setActiveTo(Date activeTo) {
		this.activeTo = activeTo;
	}

	public Date getPasswordUpdatedOn() {
		return passwordUpdatedOn;
	}

	public void setPasswordUpdatedOn(Date passwordUpdatedOn) {
		this.passwordUpdatedOn = passwordUpdatedOn;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}

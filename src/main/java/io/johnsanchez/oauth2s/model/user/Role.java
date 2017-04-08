/**
 * 
 */
package io.johnsanchez.oauth2s.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.johnsanchez.oauth2s.model.base.BaseEntity;

/**
 * @author John
 *
 */
@Entity
@Table(name="ROLE")
public class Role extends BaseEntity {

	private static final long serialVersionUID = 6070071581900410813L;
	
	@Id
	@Column(name="ROLE_ID")
	private String roleId;
	
	@Column(name="DESCRIPTION")
	private String description;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

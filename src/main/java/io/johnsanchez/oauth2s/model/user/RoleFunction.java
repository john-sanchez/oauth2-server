package io.johnsanchez.oauth2s.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.johnsanchez.oauth2s.model.base.BaseEntity;
import io.johnsanchez.oauth2s.model.id.RoleFunctionId;

/**
 * @author John
 *
 */
@Entity
@Table(name="ROLE_FUNCTION")
@IdClass(RoleFunctionId.class)
public class RoleFunction extends BaseEntity {

	private static final long serialVersionUID = -7422235399663506034L;
	
	@Id
	@Column(name="ROLE_ID")
	private String roleId;
	
	@ManyToOne
	@JoinColumn(name="ROLE_ID", insertable=false, updatable=false)
	private Role role;
	
	@Id
	@Column(name="FUNCTION_ID")
	private String functionId;
	
	@ManyToOne
	@JoinColumn(name="FUNCTION_ID", insertable=false, updatable=false)
	private Function function;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

}

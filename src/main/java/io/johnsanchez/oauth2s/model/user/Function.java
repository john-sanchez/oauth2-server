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
@Table(name="FUNCTION")
public class Function extends BaseEntity {

	private static final long serialVersionUID = 5069043648367723030L;
	
	@Id
	@Column(name="FUNCTION_ID")
	private String functionId;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

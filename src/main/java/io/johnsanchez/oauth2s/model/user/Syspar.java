/**
 * 
 */
package io.johnsanchez.oauth2s.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import io.johnsanchez.oauth2s.model.base.BaseEntity;
import io.johnsanchez.oauth2s.model.enums.SysparId;

/**
 * @author John
 *
 */
@Entity
@Table(name="SYSPAR")
public class Syspar extends BaseEntity {

	private static final long serialVersionUID = 3730615950687390607L;
	
	@Id
	@Column(name="SYSPAR_ID")
	@Enumerated(EnumType.STRING)
	private SysparId sysparId;
	
	@Column(name="VALUE")
	private String value;

	public SysparId getSysparId() {
		return sysparId;
	}

	public void setSysparId(SysparId sysparId) {
		this.sysparId = sysparId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

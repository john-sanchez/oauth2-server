package io.johnsanchez.oauth2s.pojo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.johnsanchez.oauth2s.model.enums.UserStatus;
import io.johnsanchez.oauth2s.model.user.RoleFunction;
import io.johnsanchez.oauth2s.model.user.Syspar;
import io.johnsanchez.oauth2s.model.user.User;

public class AuthUserDetails implements UserDetails {

	private static final long serialVersionUID = 8281952432834832367L;
	
	private final User user;
	private final String[] grantedAuths;
	private final int passwordExpiryDays;
	
	public AuthUserDetails(User user, List<RoleFunction> roleFunctions, Syspar syspar) {
		this.user = user;
		List<String> auths = new ArrayList<>();
		roleFunctions.forEach(t->auths.add(t.getFunctionId()));
		grantedAuths = auths.toArray(new String[auths.size()]);
		passwordExpiryDays = Integer.parseInt(syspar.getValue());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(grantedAuths);
	}

	@Override
	public boolean isAccountNonExpired() {
		Date today = new Date();
		boolean nonExpired = user.getActiveFrom() == null || user.getActiveFrom().before(today);
		nonExpired = nonExpired && (user.getActiveTo() == null || user.getActiveTo().after(today));
		return nonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return UserStatus.LOCKED != user.getStatus();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(user.getPasswordUpdatedOn());
		calendar.add(Calendar.DATE, passwordExpiryDays);
		return calendar.getTime().after(new Date());
	}

	@Override
	public boolean isEnabled() {
		return UserStatus.ACTIVE == user.getStatus();
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

}

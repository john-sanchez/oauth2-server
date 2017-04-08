package io.johnsanchez.oauth2s.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.johnsanchez.oauth2s.model.enums.SysparId;
import io.johnsanchez.oauth2s.model.user.RoleFunction;
import io.johnsanchez.oauth2s.model.user.Syspar;
import io.johnsanchez.oauth2s.model.user.User;
import io.johnsanchez.oauth2s.pojo.AuthUserDetails;
import io.johnsanchez.oauth2s.repository.RoleFunctionRepository;
import io.johnsanchez.oauth2s.repository.SysparRepository;
import io.johnsanchez.oauth2s.repository.UserRepository;

@Service
public class AuthUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleFunctionRepository roleFunctionRepository;
	
	@Autowired
	private SysparRepository sysparRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findOne(username);
		List<RoleFunction> roleFunctions = roleFunctionRepository.findByRoleId(user.getRoleId());
		Syspar syspar = sysparRepository.findOne(SysparId.PASSWORD_EXPIRY_DAYS);
		return new AuthUserDetails(user, roleFunctions, syspar);
	}

}

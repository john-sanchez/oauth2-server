package io.johnsanchez.oauth2s.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.johnsanchez.oauth2s.model.id.RoleFunctionId;
import io.johnsanchez.oauth2s.model.user.RoleFunction;

@RepositoryRestResource
public interface RoleFunctionRepository extends CrudRepository<RoleFunction, RoleFunctionId> {

	public List<RoleFunction> findByRoleId(String roleId);
	
}

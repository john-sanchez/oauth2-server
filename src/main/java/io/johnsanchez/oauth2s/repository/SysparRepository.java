package io.johnsanchez.oauth2s.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.johnsanchez.oauth2s.model.enums.SysparId;
import io.johnsanchez.oauth2s.model.user.Syspar;

@RepositoryRestResource
public interface SysparRepository extends CrudRepository<Syspar, SysparId> {

}

package io.johnsanchez.oauth2s.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.johnsanchez.oauth2s.model.user.Function;

@RepositoryRestResource
public interface FunctionRepository extends CrudRepository<Function, String> {

}

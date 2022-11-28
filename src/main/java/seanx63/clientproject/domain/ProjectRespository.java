package seanx63.clientproject.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjectRespository extends CrudRepository<Project, Long>  {
}

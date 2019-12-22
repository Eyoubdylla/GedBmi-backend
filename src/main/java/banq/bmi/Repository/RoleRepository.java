package banq.bmi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import banq.bmi.entities.Role;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long>{
	public Role findByRoleName(String roleName);

}

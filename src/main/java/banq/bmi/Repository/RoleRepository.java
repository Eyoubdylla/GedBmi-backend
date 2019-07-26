package banq.bmi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import banq.bmi.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	public Role findByRoleName(String roleName);
}

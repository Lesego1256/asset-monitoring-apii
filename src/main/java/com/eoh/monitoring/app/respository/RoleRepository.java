package com.eoh.monitoring.app.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eoh.monitoring.app.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}

package com.eoh.monitoring.app.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eoh.monitoring.app.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{


	@Query("select u from User u where  u.email=?1 and u.password=?2")
	public User login(String email, String password);
}

package com.policy.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.policy.demo.Entity.Insurance;

public interface PolicyRepository extends JpaRepository<Insurance, Integer>{

	@Query("SELECT P FROM policy P")
	List<Insurance> getAllPolicies();
	
	@Query ("SELECT P FROM policy P where P.pid = ?1 " )
	List<Insurance> getPolicyByNumber(int pId);
	
	@Query ("SELECT P FROM policy P where P.pname = ?1 " )
	List<Insurance> getPolicyByName(String pName);
}

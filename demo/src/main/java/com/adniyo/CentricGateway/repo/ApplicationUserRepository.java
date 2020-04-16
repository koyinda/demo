package com.adniyo.CentricGateway.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adniyo.CentricGateway.domain.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
	ApplicationUser findByUsername(String username);
}
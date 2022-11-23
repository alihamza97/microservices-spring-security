package com.spring.coupon.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.coupon.model.Role;
@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

}
